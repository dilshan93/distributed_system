import Util.DbConfig;
import ds.name.service.*;
import grpcConfig.InventoryControlGrpcServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class InventoryControlServer {
    public static final String NAME_SERVICE_ADDRESS = "http://localhost:2379";
    public static final String ZOOKEEPER_ADDRESS = "localhost:2181";

    private DistributedLock leaderLock;
    private int serverPort;
    private AtomicBoolean isLeader = new AtomicBoolean(false);
    private byte[] leaderData;
    private DistributedTx transaction;
    private InventoryDistributedImpl inventoryDistributed;

    public InventoryControlServer(String host, int port) throws IOException, InterruptedException, KeeperException {
        this.serverPort = port;
        leaderLock = new DistributedLock("InventoryServerCluster", buildServerData(host, port));
        inventoryDistributed = new InventoryDistributedImpl();
        transaction = new DistributedTxParticipant(inventoryDistributed);
    }

    public void startServer() throws IOException, InterruptedException, KeeperException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(new InventoryControlGrpcServiceImpl())
                .build();
        server.start();

        System.out.println("Inventory Server started on: " + serverPort);

        tryToBeLeader();
        server.awaitTermination();
    }

    public static String buildServerData(String IP, int port) {
        StringBuilder builder = new StringBuilder();
        builder.append(IP).append(":").append(port);
        return builder.toString();
    }
    private synchronized void setCurrentLeaderData(byte[] leaderData) {
        this.leaderData = leaderData;
    }

    private void tryToBeLeader() throws KeeperException, InterruptedException {
        Thread leaderCampaignThread = new Thread(new LeaderCampaignThread());
        leaderCampaignThread.start();
    }
    private void beTheLeader() {
        System.out.println("I got the leader lock. Now acting as primary");
        isLeader.set(true);
        transaction = new DistributedTxCoordinator(inventoryDistributed);
    }

    public static void main (String[] args) throws Exception{
        DistributedLock.setZooKeeperURL(ZOOKEEPER_ADDRESS);
        if (args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }
        int serverPort = Integer.parseInt(args[0]);

        // Initialize Database
        DbConfig.initDB();

        // Initialize Server
        InventoryControlServer server = new InventoryControlServer("localhost", serverPort);
        server.startServer();

        // Initialize ETCD
        NameServiceClient client = new NameServiceClient(NAME_SERVICE_ADDRESS);
        client.registerService("service.InventoryService", "127.0.0.1", serverPort, "tcp");

        Thread printingHook = new Thread(() -> {
            try {
                client.removeService("service.InventoryService");
                System.out.println("Service removed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Runtime.getRuntime().addShutdownHook(printingHook);
    }
    class LeaderCampaignThread implements Runnable {
        private byte[] currentLeaderData = null;
        @Override
        public void run() {
            System.out.println("Starting the leader Campaign");
            try {
                boolean leader = leaderLock.tryAcquireLock();
                while (!leader) {
                    byte[] leaderData = leaderLock.getLockHolderData();
                    if (currentLeaderData != leaderData) {
                        currentLeaderData = leaderData;
                        setCurrentLeaderData(currentLeaderData);
                    }
                    Thread.sleep(10000);
                    leader = leaderLock.tryAcquireLock();
                }
                System.out.println("I got the leader lock. Now acting as primary");
                currentLeaderData = null;
                beTheLeader();
            } catch (Exception e){
            }
        }
    }

}

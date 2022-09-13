package Service;

import DTOs.Order;
import DTOs.Product;
import ZooKeeper.ZookeeperService;
import ds.tutorial.communication.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.HashMap;
import java.util.Map;

public class InventoryControlServiceDistribute {

    private ManagedChannel channel = null;
    InventoryServiceGrpc.InventoryServiceBlockingStub inventoryServiceBlockingStub = null;

    public void initConnection (String host, Integer port) {
        System.out.println("Server Connection to " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        inventoryServiceBlockingStub = InventoryServiceGrpc.newBlockingStub(channel);
    }

    public void closeConnection() {
        channel.shutdown();
    }

    public Map<String, String> updateInventory(Product product) {
        if (ZookeeperService.isLeader.get()) {
            System.out.println("Update Inventory :-  Request Functioning in Primary Server : " + product.getProductId());

            InventoryContorolService service = new InventoryContorolService();
            Map<String, String> serviceResponse = service.updateInventory(product);
            return serviceResponse;
        } else {
            String[] leaderData = ZookeeperService.getCurrentLeaderData();
            System.out.println("Update Inventory :-  Request foreword to Primary Server : " + product.getProductId());

            initConnection(leaderData[0], Integer.parseInt(leaderData[1]));

            UpdateInventoryRequest request = UpdateInventoryRequest
                    .newBuilder()
                    .setProductId(product.getProductId())
                    .setCount(product.getCount())
                    .build();

            UpdateInventoryResponse response = inventoryServiceBlockingStub.updateInventory(request);

            closeConnection();

            System.out.println("Response received to Update Inventory: [" + response.getStatus() + "] " + response.getMessage());
            System.out.println("");

            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("status", response.getStatus());
            stringMap.put("message", response.getMessage());

            return stringMap;
        }

    }

    public Map<String, String> processOrder(Order order) {
        if (ZookeeperService.isLeader.get()) {
            System.out.println("Order Process :-   Request Functioning in Primary Server : " + order.getOrderNumber());

            InventoryContorolService service = new InventoryContorolService();
            Map<String, String> serviceResponse = service.processOrder(order);
            return serviceResponse;
        } else {
            String[] leaderData = ZookeeperService.getCurrentLeaderData();
            System.out.println("Order Process :-  Request foreword to Primary Server : " + order.getOrderNumber());

            initConnection(leaderData[0], Integer.parseInt(leaderData[1]));

            ProcessOrderRequest request = ProcessOrderRequest
                    .newBuilder()
                    .setOrderNumber(order.getOrderNumber())
                    .setProductId(order.getItemId())
                    .setCount(order.getCount())
                    .build();

            ProcessOrderResponse response = inventoryServiceBlockingStub.processOrder(request);

            closeConnection();

            System.out.println("Response received to Process Order: [" + response.getStatus() + "] " + response.getMessage());
            System.out.println("");

            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("status", response.getStatus());
            stringMap.put("message", response.getMessage());

            return stringMap;
        }
    }
}

import ds.name.service.NameServiceClient;
import grpcConfig.InventoryControlGrpcServiceClient;
import service.InventoryContorolServiceClient;

import java.io.IOException;
import java.util.Scanner;

public class InventoryControlClient {

    public static final String NAME_SERVICE_ADDRESS = "http://localhost:2379";
    String host = null;
    int port = -1;

    public static void main (String[] args) {
        if (args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }
        int serverPort = Integer.parseInt(args[0]);

        System.out.println("-----------------------------------------------");
        System.out.println("----!!!! Inventory Management System !!!!---");
        System.out.println("-----------------------------------------------");

        InventoryContorolServiceClient inventoryService = new InventoryContorolServiceClient(new InventoryControlGrpcServiceClient("localhost", serverPort));
        Scanner sc = new Scanner(System.in);
        int choice;
        flag:
        while (true) {

            consoleMainOptions();

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createProduct(sc);
                    break;
                case 2:
                    processOrder(sc);
                    break;
                case 3:
                    updateInventory(sc);
                    break;
                case 0:
                    System.out.println("-----------------------------------------------");
                    System.out.println("Thank You for using the Application");
                    System.out.println("-----------------------------------------------");
                    break flag;
                default:
                    System.out.println("Invalid Choice! Choose Between 1, 2, 3, or 0");
            }
        }
    }

    public static void consoleMainOptions() {
        System.out.println("Please Choose Option");
        System.out.println("-----------------------------------------------");
        System.out.println("Enter '1'  - Create Item");
        System.out.println("Enter '2'  - Process Order");
        System.out.println("Enter '3'  - Update Inventory");
        System.out.println("Enter '0' - Exit Application");
        System.out.println("-----------------------------------------------");
    }

    private static void createProduct(Scanner sc) {
        System.out.println("Enter Product Name");
        String productName = sc.next();
        System.out.println("Enter Product ID");
        String productId = sc.next();
        System.out.println("Enter Count");
        Integer count = sc.nextInt();
        InventoryContorolServiceClient serviceClient = fetchServerDetails();

        serviceClient.createProduct(productName, productId, count);
    }

    private static void processOrder( Scanner sc) {
        System.out.println("Enter Order ID");
        String orderId = sc.next();
        System.out.println("Enter Product ID");
        String productId = sc.next();
        System.out.println("Enter Count");
        Integer count = sc.nextInt();

        InventoryContorolServiceClient serviceClient = fetchServerDetails();
        serviceClient.processOrder(orderId, productId, count);
    }

    private static void updateInventory(Scanner sc){
        System.out.println("Enter Product ID");
        String productId = sc.next();
        System.out.println("Enter quantity");
        Integer count = sc.nextInt();

        InventoryContorolServiceClient serviceClient = fetchServerDetails();
        serviceClient.updateInventory(productId, count);
    }

    private static InventoryContorolServiceClient fetchServerDetails() {
        System.out.println("Get Server Ip and Port via ETCD");
        try {
        NameServiceClient client = new NameServiceClient(NAME_SERVICE_ADDRESS);
        NameServiceClient.ServiceDetails serviceDetails = client.findService("service.InventoryService");
        String host = serviceDetails.getIPAddress();
        Integer port = serviceDetails.getPort();

        System.out.println("Received Server Details! Host: " + host + " Port: " + port);

        return new InventoryContorolServiceClient(new InventoryControlGrpcServiceClient(host, port));
        } catch (IOException e) {
            System.out.println("Get Details from ETCD failed!  :- "+ e);
        } catch (InterruptedException ex) {
            System.out.println("Get Details from ETCD failed! :- "+ ex );
        }

        return null;
    }
}

package service;

import grpcConfig.InventoryControlGrpcServiceClient;

public class InventoryContorolServiceClient {

    final InventoryControlGrpcServiceClient inventoryGrpcServiceClient;

    public InventoryContorolServiceClient(InventoryControlGrpcServiceClient inventoryGrpcServiceClient) {
        this.inventoryGrpcServiceClient = inventoryGrpcServiceClient;
    }

    public void createProduct(String productName, String productId, Integer count) {
        if (productName == null || productId == null || count == null){
            System.out.println("Invalid Data! Request Failed.");
            return;
        }
        if (count <= 0) {
            System.out.println("Item count should be greater than 0.");
            return;
        }

        try {
            inventoryGrpcServiceClient.initConnection();
            inventoryGrpcServiceClient.createProduct(productName, productId, count);
            inventoryGrpcServiceClient.closeConnection();
        } catch (InterruptedException ex) {
            System.out.println("Communication with Server Failed!");
        }
    }

    public void processOrder(String orderId, String productId, Integer count) {
        if (orderId == null || productId == null || count == null){
            System.out.println("Invalid Data! Request Failed.");
            return;
        }
        if (count <= 0) {
            System.out.println("Item count should be greater than 0.");
            return;
        }

        try {
            inventoryGrpcServiceClient.initConnection();
            inventoryGrpcServiceClient.processOrder(orderId, productId, count);
            inventoryGrpcServiceClient.closeConnection();
        } catch (InterruptedException ex) {
            System.out.println("Communication with Server Failed!");
        }
    }

    public void updateInventory(String itemId, Integer count) {
        if (itemId == null || count == null){
            System.out.println("Invalid Data! Request Failed.");
            return;
        }
        if (count <= 0) {
            System.out.println("Item count should be greater than 0.");
            return;
        }

        try {
            inventoryGrpcServiceClient.initConnection();
            inventoryGrpcServiceClient.updateInventory(itemId, count);
            inventoryGrpcServiceClient.closeConnection();
        } catch (InterruptedException ex) {
            System.out.println("Communication with Server Failed!");
        }
    }
}

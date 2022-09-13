package grpcConfig;

import ds.tutorial.communication.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class InventoryControlGrpcServiceClient {

    private ManagedChannel channel = null;
    InventoryServiceGrpc.InventoryServiceBlockingStub inventoryServiceBlockingStub = null;
    String host = null;
    int port = -1;

    public InventoryControlGrpcServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initConnection () {
        System.out.println("Client Connection to " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        inventoryServiceBlockingStub = InventoryServiceGrpc.newBlockingStub(channel);
    }

    public void closeConnection() {
        channel.shutdown();
    }

    public void createProduct(String productName, String productId, Integer count) throws InterruptedException {
        System.out.println("Request sent to Create Product: " + productId);

        CreateProductRequest request = CreateProductRequest
                .newBuilder()
                .setProductId(productId)
                .setProductName(productName)
                .setCount(count)
                .build();

        CreateProductResponse response = inventoryServiceBlockingStub.createItem(request);

        System.out.println("Response received to Create Product: [" + response.getStatus() + "] " + response.getMessage());
        System.out.println("");
        Thread.sleep(1000);
    }

    public void processOrder(String orderId, String productId, Integer count) throws InterruptedException {
        System.out.println("Request sent to Process Order: " + orderId);

        ProcessOrderRequest request = ProcessOrderRequest
                .newBuilder()
                .setOrderNumber(orderId)
                .setProductId(productId)
                .setCount(count)
                .build();

        ProcessOrderResponse response = inventoryServiceBlockingStub.processOrder(request);

        System.out.println("Response received to Process Order: [" + response.getStatus() + "] " + response.getMessage());
        System.out.println("");
        Thread.sleep(1000);
    }

    public void updateInventory(String productId, Integer count) throws InterruptedException {
        System.out.println("Request sent to Update Inventory: " + productId);

        UpdateInventoryRequest request = UpdateInventoryRequest
                .newBuilder()
                .setProductId(productId)
                .setCount(count)
                .build();

        UpdateInventoryResponse response = inventoryServiceBlockingStub.updateInventory(request);

        System.out.println("Response received to Update Inventory: [" + response.getStatus() + "] " + response.getMessage());
        System.out.println("");
        Thread.sleep(1000);
    }
}

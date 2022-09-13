package grpcConfig;


import DTOs.Order;
import DTOs.Product;
import Service.InventoryContorolService;
import Service.InventoryControlServiceDistribute;
import ds.tutorial.communication.grpc.generated.*;

import java.util.Map;

public class InventoryControlGrpcServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase{

    @Override
    public void createItem(CreateProductRequest request, io.grpc.stub.StreamObserver<CreateProductResponse> responseObserver) {

        System.out.println("Request received to Create Product: " + request.getProductId());
        Product product = new Product();
        product.setProductId(request.getProductId());
        product.setProductName(request.getProductName());
        product.setCount(request.getCount());

        InventoryContorolService service = new InventoryContorolService();
        Map<String, String> serviceResponse = service.createProduct(product);

        CreateProductResponse response = CreateProductResponse
                .newBuilder()
                .setStatus(serviceResponse.get("status"))
                .setMessage(serviceResponse.get("message"))
                .build();

        System.out.println("Responding to Create Product: " + request.getProductId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void processOrder(ProcessOrderRequest request, io.grpc.stub.StreamObserver<ProcessOrderResponse> responseObserver) {
        System.out.println("Request received to Process Order: " + request.getProductId());
        Order order = new Order();
        order.setOrderNumber(request.getOrderNumber());
        order.setItemId(request.getProductId());
        order.setCount(request.getCount());

        InventoryControlServiceDistribute service = new InventoryControlServiceDistribute();
        Map<String, String> serviceResponse = service.processOrder(order);

        ProcessOrderResponse response = ProcessOrderResponse
                .newBuilder()
                .setStatus(serviceResponse.get("status"))
                .setMessage(serviceResponse.get("message"))
                .build();

        System.out.println("Responding to Process Order: " + request.getOrderNumber());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateInventory(UpdateInventoryRequest request, io.grpc.stub.StreamObserver<UpdateInventoryResponse> responseObserver) {
        System.out.println("Request received to Update Inventory of Product: " + request.getProductId());
        Product product = new Product();
        product.setProductId(request.getProductId());
        product.setCount(request.getCount());

        InventoryControlServiceDistribute service = new InventoryControlServiceDistribute();
        Map<String, String> serviceResponse = service.updateInventory(product);

        UpdateInventoryResponse response = UpdateInventoryResponse
                .newBuilder()
                .setStatus(serviceResponse.get("status"))
                .setMessage(serviceResponse.get("message"))
                .build();

        System.out.println("Responding to Update Inventory of Product: " + request.getProductId());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

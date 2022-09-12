package ds.tutorial.communication.grpc.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: InventoryService.proto")
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final String SERVICE_NAME = "ds.tutorial.communication.grpc.generated.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CreateProductRequest,
      ds.tutorial.communication.grpc.generated.CreateProductResponse> getCreateItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createItem",
      requestType = ds.tutorial.communication.grpc.generated.CreateProductRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.CreateProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CreateProductRequest,
      ds.tutorial.communication.grpc.generated.CreateProductResponse> getCreateItemMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.CreateProductRequest, ds.tutorial.communication.grpc.generated.CreateProductResponse> getCreateItemMethod;
    if ((getCreateItemMethod = InventoryServiceGrpc.getCreateItemMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getCreateItemMethod = InventoryServiceGrpc.getCreateItemMethod) == null) {
          InventoryServiceGrpc.getCreateItemMethod = getCreateItemMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.CreateProductRequest, ds.tutorial.communication.grpc.generated.CreateProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CreateProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.CreateProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("createItem"))
              .build();
        }
      }
    }
    return getCreateItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.ProcessOrderRequest,
      ds.tutorial.communication.grpc.generated.ProcessOrderResponse> getProcessOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processOrder",
      requestType = ds.tutorial.communication.grpc.generated.ProcessOrderRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.ProcessOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.ProcessOrderRequest,
      ds.tutorial.communication.grpc.generated.ProcessOrderResponse> getProcessOrderMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.ProcessOrderRequest, ds.tutorial.communication.grpc.generated.ProcessOrderResponse> getProcessOrderMethod;
    if ((getProcessOrderMethod = InventoryServiceGrpc.getProcessOrderMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getProcessOrderMethod = InventoryServiceGrpc.getProcessOrderMethod) == null) {
          InventoryServiceGrpc.getProcessOrderMethod = getProcessOrderMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.ProcessOrderRequest, ds.tutorial.communication.grpc.generated.ProcessOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.ProcessOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.ProcessOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("processOrder"))
              .build();
        }
      }
    }
    return getProcessOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateInventoryRequest,
      ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> getUpdateInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInventory",
      requestType = ds.tutorial.communication.grpc.generated.UpdateInventoryRequest.class,
      responseType = ds.tutorial.communication.grpc.generated.UpdateInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateInventoryRequest,
      ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> getUpdateInventoryMethod() {
    io.grpc.MethodDescriptor<ds.tutorial.communication.grpc.generated.UpdateInventoryRequest, ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> getUpdateInventoryMethod;
    if ((getUpdateInventoryMethod = InventoryServiceGrpc.getUpdateInventoryMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getUpdateInventoryMethod = InventoryServiceGrpc.getUpdateInventoryMethod) == null) {
          InventoryServiceGrpc.getUpdateInventoryMethod = getUpdateInventoryMethod =
              io.grpc.MethodDescriptor.<ds.tutorial.communication.grpc.generated.UpdateInventoryRequest, ds.tutorial.communication.grpc.generated.UpdateInventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.UpdateInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.tutorial.communication.grpc.generated.UpdateInventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("updateInventory"))
              .build();
        }
      }
    }
    return getUpdateInventoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub>() {
        @java.lang.Override
        public InventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceStub(channel, callOptions);
        }
      };
    return InventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub>() {
        @java.lang.Override
        public InventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub>() {
        @java.lang.Override
        public InventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class InventoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createItem(ds.tutorial.communication.grpc.generated.CreateProductRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CreateProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateItemMethod(), responseObserver);
    }

    /**
     */
    public void processOrder(ds.tutorial.communication.grpc.generated.ProcessOrderRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.ProcessOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessOrderMethod(), responseObserver);
    }

    /**
     */
    public void updateInventory(ds.tutorial.communication.grpc.generated.UpdateInventoryRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInventoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateItemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.CreateProductRequest,
                ds.tutorial.communication.grpc.generated.CreateProductResponse>(
                  this, METHODID_CREATE_ITEM)))
          .addMethod(
            getProcessOrderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.ProcessOrderRequest,
                ds.tutorial.communication.grpc.generated.ProcessOrderResponse>(
                  this, METHODID_PROCESS_ORDER)))
          .addMethod(
            getUpdateInventoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ds.tutorial.communication.grpc.generated.UpdateInventoryRequest,
                ds.tutorial.communication.grpc.generated.UpdateInventoryResponse>(
                  this, METHODID_UPDATE_INVENTORY)))
          .build();
    }
  }

  /**
   */
  public static final class InventoryServiceStub extends io.grpc.stub.AbstractAsyncStub<InventoryServiceStub> {
    private InventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void createItem(ds.tutorial.communication.grpc.generated.CreateProductRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CreateProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void processOrder(ds.tutorial.communication.grpc.generated.ProcessOrderRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.ProcessOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateInventory(ds.tutorial.communication.grpc.generated.UpdateInventoryRequest request,
        io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInventoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InventoryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.CreateProductResponse createItem(ds.tutorial.communication.grpc.generated.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.ProcessOrderResponse processOrder(ds.tutorial.communication.grpc.generated.ProcessOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.tutorial.communication.grpc.generated.UpdateInventoryResponse updateInventory(ds.tutorial.communication.grpc.generated.UpdateInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInventoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InventoryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.CreateProductResponse> createItem(
        ds.tutorial.communication.grpc.generated.CreateProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateItemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.ProcessOrderResponse> processOrder(
        ds.tutorial.communication.grpc.generated.ProcessOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.tutorial.communication.grpc.generated.UpdateInventoryResponse> updateInventory(
        ds.tutorial.communication.grpc.generated.UpdateInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInventoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ITEM = 0;
  private static final int METHODID_PROCESS_ORDER = 1;
  private static final int METHODID_UPDATE_INVENTORY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ITEM:
          serviceImpl.createItem((ds.tutorial.communication.grpc.generated.CreateProductRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.CreateProductResponse>) responseObserver);
          break;
        case METHODID_PROCESS_ORDER:
          serviceImpl.processOrder((ds.tutorial.communication.grpc.generated.ProcessOrderRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.ProcessOrderResponse>) responseObserver);
          break;
        case METHODID_UPDATE_INVENTORY:
          serviceImpl.updateInventory((ds.tutorial.communication.grpc.generated.UpdateInventoryRequest) request,
              (io.grpc.stub.StreamObserver<ds.tutorial.communication.grpc.generated.UpdateInventoryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.tutorial.communication.grpc.generated.InventoryServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getCreateItemMethod())
              .addMethod(getProcessOrderMethod())
              .addMethod(getUpdateInventoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}

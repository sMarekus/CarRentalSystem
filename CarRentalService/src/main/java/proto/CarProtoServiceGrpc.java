package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: car.proto")
public final class CarProtoServiceGrpc {

  private CarProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CarProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Car.CarProtoObj,
      proto.Car.CarProtoObj> getCreateCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCar",
      requestType = proto.Car.CarProtoObj.class,
      responseType = proto.Car.CarProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Car.CarProtoObj,
      proto.Car.CarProtoObj> getCreateCarMethod() {
    io.grpc.MethodDescriptor<proto.Car.CarProtoObj, proto.Car.CarProtoObj> getCreateCarMethod;
    if ((getCreateCarMethod = CarProtoServiceGrpc.getCreateCarMethod) == null) {
      synchronized (CarProtoServiceGrpc.class) {
        if ((getCreateCarMethod = CarProtoServiceGrpc.getCreateCarMethod) == null) {
          CarProtoServiceGrpc.getCreateCarMethod = getCreateCarMethod = 
              io.grpc.MethodDescriptor.<proto.Car.CarProtoObj, proto.Car.CarProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.CarProtoService", "CreateCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarProtoObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CarProtoServiceMethodDescriptorSupplier("CreateCar"))
                  .build();
          }
        }
     }
     return getCreateCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getGetCarByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCarById",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = proto.Car.CarProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getGetCarByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, proto.Car.CarProtoObj> getGetCarByIdMethod;
    if ((getGetCarByIdMethod = CarProtoServiceGrpc.getGetCarByIdMethod) == null) {
      synchronized (CarProtoServiceGrpc.class) {
        if ((getGetCarByIdMethod = CarProtoServiceGrpc.getGetCarByIdMethod) == null) {
          CarProtoServiceGrpc.getGetCarByIdMethod = getGetCarByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, proto.Car.CarProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.CarProtoService", "GetCarById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CarProtoServiceMethodDescriptorSupplier("GetCarById"))
                  .build();
          }
        }
     }
     return getGetCarByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Car.CarFilterProtoObj,
      proto.Car.ListCarObj> getGetCarsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCars",
      requestType = proto.Car.CarFilterProtoObj.class,
      responseType = proto.Car.ListCarObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Car.CarFilterProtoObj,
      proto.Car.ListCarObj> getGetCarsMethod() {
    io.grpc.MethodDescriptor<proto.Car.CarFilterProtoObj, proto.Car.ListCarObj> getGetCarsMethod;
    if ((getGetCarsMethod = CarProtoServiceGrpc.getGetCarsMethod) == null) {
      synchronized (CarProtoServiceGrpc.class) {
        if ((getGetCarsMethod = CarProtoServiceGrpc.getGetCarsMethod) == null) {
          CarProtoServiceGrpc.getGetCarsMethod = getGetCarsMethod = 
              io.grpc.MethodDescriptor.<proto.Car.CarFilterProtoObj, proto.Car.ListCarObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.CarProtoService", "GetCars"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarFilterProtoObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.ListCarObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CarProtoServiceMethodDescriptorSupplier("GetCars"))
                  .build();
          }
        }
     }
     return getGetCarsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getDeleteCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCar",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = proto.Car.CarProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getDeleteCarMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, proto.Car.CarProtoObj> getDeleteCarMethod;
    if ((getDeleteCarMethod = CarProtoServiceGrpc.getDeleteCarMethod) == null) {
      synchronized (CarProtoServiceGrpc.class) {
        if ((getDeleteCarMethod = CarProtoServiceGrpc.getDeleteCarMethod) == null) {
          CarProtoServiceGrpc.getDeleteCarMethod = getDeleteCarMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, proto.Car.CarProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.CarProtoService", "DeleteCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CarProtoServiceMethodDescriptorSupplier("DeleteCar"))
                  .build();
          }
        }
     }
     return getDeleteCarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getUpdateCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCar",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = proto.Car.CarProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Car.CarProtoObj> getUpdateCarMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, proto.Car.CarProtoObj> getUpdateCarMethod;
    if ((getUpdateCarMethod = CarProtoServiceGrpc.getUpdateCarMethod) == null) {
      synchronized (CarProtoServiceGrpc.class) {
        if ((getUpdateCarMethod = CarProtoServiceGrpc.getUpdateCarMethod) == null) {
          CarProtoServiceGrpc.getUpdateCarMethod = getUpdateCarMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, proto.Car.CarProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.CarProtoService", "UpdateCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Car.CarProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new CarProtoServiceMethodDescriptorSupplier("UpdateCar"))
                  .build();
          }
        }
     }
     return getUpdateCarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarProtoServiceStub newStub(io.grpc.Channel channel) {
    return new CarProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CarProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CarProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CarProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCar(proto.Car.CarProtoObj request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCarMethod(), responseObserver);
    }

    /**
     */
    public void getCarById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCarByIdMethod(), responseObserver);
    }

    /**
     */
    public void getCars(proto.Car.CarFilterProtoObj request,
        io.grpc.stub.StreamObserver<proto.Car.ListCarObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCarsMethod(), responseObserver);
    }

    /**
     */
    public void deleteCar(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCarMethod(), responseObserver);
    }

    /**
     */
    public void updateCar(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCarMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Car.CarProtoObj,
                proto.Car.CarProtoObj>(
                  this, METHODID_CREATE_CAR)))
          .addMethod(
            getGetCarByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                proto.Car.CarProtoObj>(
                  this, METHODID_GET_CAR_BY_ID)))
          .addMethod(
            getGetCarsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Car.CarFilterProtoObj,
                proto.Car.ListCarObj>(
                  this, METHODID_GET_CARS)))
          .addMethod(
            getDeleteCarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                proto.Car.CarProtoObj>(
                  this, METHODID_DELETE_CAR)))
          .addMethod(
            getUpdateCarMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                proto.Car.CarProtoObj>(
                  this, METHODID_UPDATE_CAR)))
          .build();
    }
  }

  /**
   */
  public static final class CarProtoServiceStub extends io.grpc.stub.AbstractStub<CarProtoServiceStub> {
    private CarProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCar(proto.Car.CarProtoObj request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCarById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCarByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCars(proto.Car.CarFilterProtoObj request,
        io.grpc.stub.StreamObserver<proto.Car.ListCarObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCarsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCar(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCar(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Car.CarProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CarProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<CarProtoServiceBlockingStub> {
    private CarProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Car.CarProtoObj createCar(proto.Car.CarProtoObj request) {
      return blockingUnaryCall(
          getChannel(), getCreateCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Car.CarProtoObj getCarById(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getGetCarByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Car.ListCarObj getCars(proto.Car.CarFilterProtoObj request) {
      return blockingUnaryCall(
          getChannel(), getGetCarsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Car.CarProtoObj deleteCar(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCarMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Car.CarProtoObj updateCar(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCarMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CarProtoServiceFutureStub extends io.grpc.stub.AbstractStub<CarProtoServiceFutureStub> {
    private CarProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Car.CarProtoObj> createCar(
        proto.Car.CarProtoObj request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Car.CarProtoObj> getCarById(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCarByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Car.ListCarObj> getCars(
        proto.Car.CarFilterProtoObj request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCarsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Car.CarProtoObj> deleteCar(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Car.CarProtoObj> updateCar(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CAR = 0;
  private static final int METHODID_GET_CAR_BY_ID = 1;
  private static final int METHODID_GET_CARS = 2;
  private static final int METHODID_DELETE_CAR = 3;
  private static final int METHODID_UPDATE_CAR = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CarProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CarProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CAR:
          serviceImpl.createCar((proto.Car.CarProtoObj) request,
              (io.grpc.stub.StreamObserver<proto.Car.CarProtoObj>) responseObserver);
          break;
        case METHODID_GET_CAR_BY_ID:
          serviceImpl.getCarById((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<proto.Car.CarProtoObj>) responseObserver);
          break;
        case METHODID_GET_CARS:
          serviceImpl.getCars((proto.Car.CarFilterProtoObj) request,
              (io.grpc.stub.StreamObserver<proto.Car.ListCarObj>) responseObserver);
          break;
        case METHODID_DELETE_CAR:
          serviceImpl.deleteCar((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<proto.Car.CarProtoObj>) responseObserver);
          break;
        case METHODID_UPDATE_CAR:
          serviceImpl.updateCar((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<proto.Car.CarProtoObj>) responseObserver);
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

  private static abstract class CarProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Car.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarProtoService");
    }
  }

  private static final class CarProtoServiceFileDescriptorSupplier
      extends CarProtoServiceBaseDescriptorSupplier {
    CarProtoServiceFileDescriptorSupplier() {}
  }

  private static final class CarProtoServiceMethodDescriptorSupplier
      extends CarProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CarProtoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CarProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarProtoServiceFileDescriptorSupplier())
              .addMethod(getCreateCarMethod())
              .addMethod(getGetCarByIdMethod())
              .addMethod(getGetCarsMethod())
              .addMethod(getDeleteCarMethod())
              .addMethod(getUpdateCarMethod())
              .build();
        }
      }
    }
    return result;
  }
}

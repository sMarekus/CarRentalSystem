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
    comments = "Source: reservation.proto")
public final class ReservationProtoServiceGrpc {

  private ReservationProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ReservationProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Reservation.ReservationProtoObj,
      proto.Reservation.ReservationProtoObj> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = proto.Reservation.ReservationProtoObj.class,
      responseType = proto.Reservation.ReservationProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Reservation.ReservationProtoObj,
      proto.Reservation.ReservationProtoObj> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<proto.Reservation.ReservationProtoObj, proto.Reservation.ReservationProtoObj> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationProtoServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationProtoServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationProtoServiceGrpc.getCreateReservationMethod) == null) {
          ReservationProtoServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<proto.Reservation.ReservationProtoObj, proto.Reservation.ReservationProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.ReservationProtoService", "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationProtoServiceMethodDescriptorSupplier("CreateReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.Reservation.ReservationProtoList> getGetAllReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllReservations",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.Reservation.ReservationProtoList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.Reservation.ReservationProtoList> getGetAllReservationsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.Reservation.ReservationProtoList> getGetAllReservationsMethod;
    if ((getGetAllReservationsMethod = ReservationProtoServiceGrpc.getGetAllReservationsMethod) == null) {
      synchronized (ReservationProtoServiceGrpc.class) {
        if ((getGetAllReservationsMethod = ReservationProtoServiceGrpc.getGetAllReservationsMethod) == null) {
          ReservationProtoServiceGrpc.getGetAllReservationsMethod = getGetAllReservationsMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.Reservation.ReservationProtoList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.ReservationProtoService", "GetAllReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoList.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationProtoServiceMethodDescriptorSupplier("GetAllReservations"))
                  .build();
          }
        }
     }
     return getGetAllReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Reservation.ReservationProtoObj> getGetReservationByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationById",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = proto.Reservation.ReservationProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Reservation.ReservationProtoObj> getGetReservationByIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, proto.Reservation.ReservationProtoObj> getGetReservationByIdMethod;
    if ((getGetReservationByIdMethod = ReservationProtoServiceGrpc.getGetReservationByIdMethod) == null) {
      synchronized (ReservationProtoServiceGrpc.class) {
        if ((getGetReservationByIdMethod = ReservationProtoServiceGrpc.getGetReservationByIdMethod) == null) {
          ReservationProtoServiceGrpc.getGetReservationByIdMethod = getGetReservationByIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, proto.Reservation.ReservationProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.ReservationProtoService", "GetReservationById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationProtoServiceMethodDescriptorSupplier("GetReservationById"))
                  .build();
          }
        }
     }
     return getGetReservationByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Reservation.ReservationProtoList> getGetReservationsByCarIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationsByCarId",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = proto.Reservation.ReservationProtoList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      proto.Reservation.ReservationProtoList> getGetReservationsByCarIdMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, proto.Reservation.ReservationProtoList> getGetReservationsByCarIdMethod;
    if ((getGetReservationsByCarIdMethod = ReservationProtoServiceGrpc.getGetReservationsByCarIdMethod) == null) {
      synchronized (ReservationProtoServiceGrpc.class) {
        if ((getGetReservationsByCarIdMethod = ReservationProtoServiceGrpc.getGetReservationsByCarIdMethod) == null) {
          ReservationProtoServiceGrpc.getGetReservationsByCarIdMethod = getGetReservationsByCarIdMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, proto.Reservation.ReservationProtoList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.ReservationProtoService", "GetReservationsByCarId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoList.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationProtoServiceMethodDescriptorSupplier("GetReservationsByCarId"))
                  .build();
          }
        }
     }
     return getGetReservationsByCarIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      proto.Reservation.ReservationProtoList> getGetReservationsByUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationsByUserName",
      requestType = com.google.protobuf.StringValue.class,
      responseType = proto.Reservation.ReservationProtoList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      proto.Reservation.ReservationProtoList> getGetReservationsByUserNameMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, proto.Reservation.ReservationProtoList> getGetReservationsByUserNameMethod;
    if ((getGetReservationsByUserNameMethod = ReservationProtoServiceGrpc.getGetReservationsByUserNameMethod) == null) {
      synchronized (ReservationProtoServiceGrpc.class) {
        if ((getGetReservationsByUserNameMethod = ReservationProtoServiceGrpc.getGetReservationsByUserNameMethod) == null) {
          ReservationProtoServiceGrpc.getGetReservationsByUserNameMethod = getGetReservationsByUserNameMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, proto.Reservation.ReservationProtoList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.ReservationProtoService", "GetReservationsByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Reservation.ReservationProtoList.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationProtoServiceMethodDescriptorSupplier("GetReservationsByUserName"))
                  .build();
          }
        }
     }
     return getGetReservationsByUserNameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationProtoServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createReservation(proto.Reservation.ReservationProtoObj request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void getAllReservations(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllReservationsMethod(), responseObserver);
    }

    /**
     */
    public void getReservationById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByIdMethod(), responseObserver);
    }

    /**
     */
    public void getReservationsByCarId(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationsByCarIdMethod(), responseObserver);
    }

    /**
     */
    public void getReservationsByUserName(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationsByUserNameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Reservation.ReservationProtoObj,
                proto.Reservation.ReservationProtoObj>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getGetAllReservationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.Reservation.ReservationProtoList>(
                  this, METHODID_GET_ALL_RESERVATIONS)))
          .addMethod(
            getGetReservationByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                proto.Reservation.ReservationProtoObj>(
                  this, METHODID_GET_RESERVATION_BY_ID)))
          .addMethod(
            getGetReservationsByCarIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Int32Value,
                proto.Reservation.ReservationProtoList>(
                  this, METHODID_GET_RESERVATIONS_BY_CAR_ID)))
          .addMethod(
            getGetReservationsByUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                proto.Reservation.ReservationProtoList>(
                  this, METHODID_GET_RESERVATIONS_BY_USER_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationProtoServiceStub extends io.grpc.stub.AbstractStub<ReservationProtoServiceStub> {
    private ReservationProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(proto.Reservation.ReservationProtoObj request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllReservations(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationById(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationsByCarId(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationsByCarIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationsByUserName(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationsByUserNameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationProtoServiceBlockingStub> {
    private ReservationProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Reservation.ReservationProtoObj createReservation(proto.Reservation.ReservationProtoObj request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Reservation.ReservationProtoList getAllReservations(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllReservationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Reservation.ReservationProtoObj getReservationById(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Reservation.ReservationProtoList getReservationsByCarId(com.google.protobuf.Int32Value request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationsByCarIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Reservation.ReservationProtoList getReservationsByUserName(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationsByUserNameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationProtoServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationProtoServiceFutureStub> {
    private ReservationProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Reservation.ReservationProtoObj> createReservation(
        proto.Reservation.ReservationProtoObj request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Reservation.ReservationProtoList> getAllReservations(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Reservation.ReservationProtoObj> getReservationById(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Reservation.ReservationProtoList> getReservationsByCarId(
        com.google.protobuf.Int32Value request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationsByCarIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Reservation.ReservationProtoList> getReservationsByUserName(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationsByUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_GET_ALL_RESERVATIONS = 1;
  private static final int METHODID_GET_RESERVATION_BY_ID = 2;
  private static final int METHODID_GET_RESERVATIONS_BY_CAR_ID = 3;
  private static final int METHODID_GET_RESERVATIONS_BY_USER_NAME = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((proto.Reservation.ReservationProtoObj) request,
              (io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj>) responseObserver);
          break;
        case METHODID_GET_ALL_RESERVATIONS:
          serviceImpl.getAllReservations((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_ID:
          serviceImpl.getReservationById((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoObj>) responseObserver);
          break;
        case METHODID_GET_RESERVATIONS_BY_CAR_ID:
          serviceImpl.getReservationsByCarId((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList>) responseObserver);
          break;
        case METHODID_GET_RESERVATIONS_BY_USER_NAME:
          serviceImpl.getReservationsByUserName((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<proto.Reservation.ReservationProtoList>) responseObserver);
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

  private static abstract class ReservationProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Reservation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationProtoService");
    }
  }

  private static final class ReservationProtoServiceFileDescriptorSupplier
      extends ReservationProtoServiceBaseDescriptorSupplier {
    ReservationProtoServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationProtoServiceMethodDescriptorSupplier
      extends ReservationProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationProtoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationProtoServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetAllReservationsMethod())
              .addMethod(getGetReservationByIdMethod())
              .addMethod(getGetReservationsByCarIdMethod())
              .addMethod(getGetReservationsByUserNameMethod())
              .build();
        }
      }
    }
    return result;
  }
}

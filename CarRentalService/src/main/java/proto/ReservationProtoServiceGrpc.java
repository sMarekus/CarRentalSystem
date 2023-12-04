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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Reservation.ReservationProtoObj,
                proto.Reservation.ReservationProtoObj>(
                  this, METHODID_CREATE_RESERVATION)))
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
  }

  private static final int METHODID_CREATE_RESERVATION = 0;

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
              .build();
        }
      }
    }
    return result;
  }
}

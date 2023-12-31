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
    comments = "Source: user.proto")
public final class UserProtoServiceGrpc {

  private UserProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.UserProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.User.UserProtoObj,
      proto.User.UserProtoObj> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = proto.User.UserProtoObj.class,
      responseType = proto.User.UserProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.User.UserProtoObj,
      proto.User.UserProtoObj> getCreateUserMethod() {
    io.grpc.MethodDescriptor<proto.User.UserProtoObj, proto.User.UserProtoObj> getCreateUserMethod;
    if ((getCreateUserMethod = UserProtoServiceGrpc.getCreateUserMethod) == null) {
      synchronized (UserProtoServiceGrpc.class) {
        if ((getCreateUserMethod = UserProtoServiceGrpc.getCreateUserMethod) == null) {
          UserProtoServiceGrpc.getCreateUserMethod = getCreateUserMethod = 
              io.grpc.MethodDescriptor.<proto.User.UserProtoObj, proto.User.UserProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.UserProtoService", "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserProtoObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new UserProtoServiceMethodDescriptorSupplier("CreateUser"))
                  .build();
          }
        }
     }
     return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.User.UserProtoObj,
      proto.User.UserProtoObj> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = proto.User.UserProtoObj.class,
      responseType = proto.User.UserProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.User.UserProtoObj,
      proto.User.UserProtoObj> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<proto.User.UserProtoObj, proto.User.UserProtoObj> getUpdateUserMethod;
    if ((getUpdateUserMethod = UserProtoServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (UserProtoServiceGrpc.class) {
        if ((getUpdateUserMethod = UserProtoServiceGrpc.getUpdateUserMethod) == null) {
          UserProtoServiceGrpc.getUpdateUserMethod = getUpdateUserMethod = 
              io.grpc.MethodDescriptor.<proto.User.UserProtoObj, proto.User.UserProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.UserProtoService", "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserProtoObj.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new UserProtoServiceMethodDescriptorSupplier("UpdateUser"))
                  .build();
          }
        }
     }
     return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.User.UserListResponse> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllUsers",
      requestType = com.google.protobuf.Empty.class,
      responseType = proto.User.UserListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      proto.User.UserListResponse> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, proto.User.UserListResponse> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = UserProtoServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (UserProtoServiceGrpc.class) {
        if ((getGetAllUsersMethod = UserProtoServiceGrpc.getGetAllUsersMethod) == null) {
          UserProtoServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, proto.User.UserListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.UserProtoService", "GetAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserProtoServiceMethodDescriptorSupplier("GetAllUsers"))
                  .build();
          }
        }
     }
     return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      proto.User.UserProtoObj> getFetchUserByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchUserByUsername",
      requestType = com.google.protobuf.StringValue.class,
      responseType = proto.User.UserProtoObj.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      proto.User.UserProtoObj> getFetchUserByUsernameMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, proto.User.UserProtoObj> getFetchUserByUsernameMethod;
    if ((getFetchUserByUsernameMethod = UserProtoServiceGrpc.getFetchUserByUsernameMethod) == null) {
      synchronized (UserProtoServiceGrpc.class) {
        if ((getFetchUserByUsernameMethod = UserProtoServiceGrpc.getFetchUserByUsernameMethod) == null) {
          UserProtoServiceGrpc.getFetchUserByUsernameMethod = getFetchUserByUsernameMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, proto.User.UserProtoObj>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.UserProtoService", "FetchUserByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.User.UserProtoObj.getDefaultInstance()))
                  .setSchemaDescriptor(new UserProtoServiceMethodDescriptorSupplier("FetchUserByUsername"))
                  .build();
          }
        }
     }
     return getFetchUserByUsernameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserProtoServiceStub newStub(io.grpc.Channel channel) {
    return new UserProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(proto.User.UserProtoObj request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    public void updateUser(proto.User.UserProtoObj request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    public void getAllUsers(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.User.UserListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    public void fetchUserByUsername(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchUserByUsernameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.User.UserProtoObj,
                proto.User.UserProtoObj>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            getUpdateUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.User.UserProtoObj,
                proto.User.UserProtoObj>(
                  this, METHODID_UPDATE_USER)))
          .addMethod(
            getGetAllUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                proto.User.UserListResponse>(
                  this, METHODID_GET_ALL_USERS)))
          .addMethod(
            getFetchUserByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                proto.User.UserProtoObj>(
                  this, METHODID_FETCH_USER_BY_USERNAME)))
          .build();
    }
  }

  /**
   */
  public static final class UserProtoServiceStub extends io.grpc.stub.AbstractStub<UserProtoServiceStub> {
    private UserProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(proto.User.UserProtoObj request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(proto.User.UserProtoObj request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<proto.User.UserListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchUserByUsername(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<proto.User.UserProtoObj> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchUserByUsernameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<UserProtoServiceBlockingStub> {
    private UserProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.User.UserProtoObj createUser(proto.User.UserProtoObj request) {
      return blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.User.UserProtoObj updateUser(proto.User.UserProtoObj request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.User.UserListResponse getAllUsers(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.User.UserProtoObj fetchUserByUsername(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getFetchUserByUsernameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserProtoServiceFutureStub extends io.grpc.stub.AbstractStub<UserProtoServiceFutureStub> {
    private UserProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.User.UserProtoObj> createUser(
        proto.User.UserProtoObj request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.User.UserProtoObj> updateUser(
        proto.User.UserProtoObj request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.User.UserListResponse> getAllUsers(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.User.UserProtoObj> fetchUserByUsername(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchUserByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_UPDATE_USER = 1;
  private static final int METHODID_GET_ALL_USERS = 2;
  private static final int METHODID_FETCH_USER_BY_USERNAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((proto.User.UserProtoObj) request,
              (io.grpc.stub.StreamObserver<proto.User.UserProtoObj>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((proto.User.UserProtoObj) request,
              (io.grpc.stub.StreamObserver<proto.User.UserProtoObj>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<proto.User.UserListResponse>) responseObserver);
          break;
        case METHODID_FETCH_USER_BY_USERNAME:
          serviceImpl.fetchUserByUsername((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<proto.User.UserProtoObj>) responseObserver);
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

  private static abstract class UserProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserProtoService");
    }
  }

  private static final class UserProtoServiceFileDescriptorSupplier
      extends UserProtoServiceBaseDescriptorSupplier {
    UserProtoServiceFileDescriptorSupplier() {}
  }

  private static final class UserProtoServiceMethodDescriptorSupplier
      extends UserProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserProtoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserProtoServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getFetchUserByUsernameMethod())
              .build();
        }
      }
    }
    return result;
  }
}

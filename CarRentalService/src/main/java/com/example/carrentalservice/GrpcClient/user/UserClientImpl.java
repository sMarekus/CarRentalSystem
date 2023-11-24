package com.example.carrentalservice.GrpcClient.user;

import com.example.carrentalservice.GrpcClient.ManagedChannelProvider;
import com.example.carrentalservice.GrpcClient.user.IUserClient;
import com.example.carrentalservice.model.User;
import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;
import proto.UserProtoServiceGrpc;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClientImpl implements IUserClient
{
    private UserProtoServiceGrpc.UserProtoServiceBlockingStub userStub;

    public UserProtoServiceGrpc.UserProtoServiceBlockingStub getUserStub() {
        if (userStub == null) {
            ManagedChannel channel = ManagedChannelProvider.getChannel();
            userStub = UserProtoServiceGrpc.newBlockingStub(channel);
        }
        return userStub;
    }

    @Override
    public User createUser(User user) {
        try {
            System.out.println("Creating user");
            proto.User.UserProtoObj userProtoObj = fromEntityToProtoObj(user);
            proto.User.UserProtoObj protoObjFromServer = getUserStub().createUser(userProtoObj);
            return fromProtoObjToEntity(protoObjFromServer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            proto.User.UserListResponse allUsers = getUserStub().getAllUsers(Empty.newBuilder().build());
            List<User> users=new ArrayList<>();
            for (proto.User.UserProtoObj userProtoObj : allUsers.getAllUsersList()) {
                User user=(fromProtoObjToEntity(userProtoObj));
                users.add(user);
            }
            return users;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        try {
            proto.User.UserProtoObj userProtoObj = getUserStub().fetchUserByUsername(StringValue.of(userName));
            User user= fromProtoObjToEntity(userProtoObj);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static proto.User.UserProtoObj fromEntityToProtoObj(User userEntity) {
        proto.User.UserProtoObj.Builder builder = proto.User.UserProtoObj.newBuilder()
                .setFirstName(userEntity.getFirstName())
                .setLastName(userEntity.getLastName())
                .setEmail(userEntity.getEmail())
                .setPassword(userEntity.getPassword())
                .setUsername(userEntity.getUsername())
                .setPhoneNumber(userEntity.getPhoneNumber())
                .setIsAdmin(userEntity.getIsAdmin());
        return builder.build();
    }


    public static User fromProtoObjToEntity(proto.User.UserProtoObj userProtoObj) {
        User userEntity = new User();
        userEntity.setFirstName(userProtoObj.getFirstName());
        userEntity.setLastName(userProtoObj.getLastName());
        userEntity.setEmail(userProtoObj.getEmail());
        userEntity.setPassword(userProtoObj.getPassword());
        userEntity.setUsername(userProtoObj.getUsername());
        userEntity.setPhoneNumber((int)userProtoObj.getPhoneNumber());
        userEntity.setIsAdmin(userProtoObj.getIsAdmin());
        return userEntity;
    }
}
package com.example.carrentalservice.GrpcClient.User;

import com.example.carrentalservice.model.User;

import java.util.List;

public interface IUserClient
{
    User createUser(User user);
    User updateUser( User user);
    List<User> getUsers();
    User getUserByUserName(String userName);

}

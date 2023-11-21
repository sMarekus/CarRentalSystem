package com.example.carrentalservice.GrpcClient;

import com.example.carrentalservice.model.User;

import java.util.List;

public interface IUserClient
{
    User createUser(User user);
    List<User> getUsers();
    User getUserByUserName(String userName);

}

package com.example.carrentalservice.GrpcClient;

import com.example.carrentalservice.model.User;

public interface IUserClient
{
    User createUser(User user);

}

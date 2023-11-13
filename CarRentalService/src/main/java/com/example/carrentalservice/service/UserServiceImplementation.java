package com.example.carrentalservice.service;

import com.example.carrentalservice.GrpcClient.IUserClient;
import com.example.carrentalservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements IUserService
{
    private final IUserClient client;

    @Autowired
    public UserServiceImplementation(IUserClient client) {
        this.client = client;
    }

    @Override
    public User createUser(User user) {
        try {
            return client.createUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsers() {
        try {
            List<User> users = client.getUsers();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public User getUserByCprNumber(long cprNumber) {
        try{
            User user = client.getUserByCprNumber(cprNumber);
            return user;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

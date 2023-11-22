package com.example.carrentalservice.service;
import com.example.carrentalservice.model.User;

import java.util.List;


public interface IUserService
{
    User createUser(User user);
    List<User> getUsers();
    User getUserByUserName(String userName);

}


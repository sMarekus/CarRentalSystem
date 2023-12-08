package com.example.carrentalservice.service.User;
import com.example.carrentalservice.model.User;

import java.util.List;


public interface IUserService
{
    User createUser(User user);
    User updateUser( User user);
    List<User> getUsers();
    User getUserByUserName(String userName);

}


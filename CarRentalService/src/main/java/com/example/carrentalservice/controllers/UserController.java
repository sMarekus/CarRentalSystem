package com.example.carrentalservice.controllers;

import com.example.carrentalservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UserController {

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try{
            System.out.println(user.getFirstName() + " " + user.getLastName());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        try{
            List<User> users = List.of(new User("John", "Doe")
                , new User("Jane", "Doe"),
                        new User("John", "Smith"));


            users.forEach(System.out::println);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}

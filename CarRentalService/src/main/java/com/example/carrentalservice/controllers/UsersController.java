package com.example.carrentalservice.controllers;

import com.example.carrentalservice.model.User;
import com.example.carrentalservice.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UsersController {

    private final IUserService userService;
    public UsersController(IUserService userService) {
        this.userService = userService;

    }


    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try{
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> userEntities = userService.getUsers();
            return new ResponseEntity<>(userEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{cprNumber}")
    public ResponseEntity<User> getUserByCprNumber(@PathVariable("cprNumber") long cprNumber) {
        try {
            User user = userService.getUserByCprNumber(cprNumber);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
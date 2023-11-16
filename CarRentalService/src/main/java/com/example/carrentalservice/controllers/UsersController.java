package com.example.carrentalservice.controllers;

import com.example.carrentalservice.Jwt.auth.AuthenticationResponse;
import com.example.carrentalservice.dto.LoginDto;
import com.example.carrentalservice.model.User;
import com.example.carrentalservice.service.IUserService;
import com.example.carrentalservice.service.UserServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UsersController {

    private final IUserService userService;
    private  final UserServiceImplementation service;
    public UsersController(IUserService userService, UserServiceImplementation service) {
        this.userService = userService;

        this.service = service;
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

    @PostMapping("/users/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody LoginDto request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
package com.example.carrentalservice.controllers.user;

import com.example.carrentalservice.Jwt.auth.AuthenticationResponse;
import com.example.carrentalservice.dto.LoginDto;
import com.example.carrentalservice.model.User;
import com.example.carrentalservice.service.user.IUserService;
import com.example.carrentalservice.service.user.UserServiceImplementation;
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

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        try {
            User user = userService.getUserByUserName(username);
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
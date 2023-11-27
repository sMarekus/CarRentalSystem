package com.example.carrentalservice.service.User;

import com.example.carrentalservice.GrpcClient.User.IUserClient;
import com.example.carrentalservice.Jwt.JwtService;
import com.example.carrentalservice.Jwt.auth.AuthenticationResponse;
import com.example.carrentalservice.dto.LoginDto;
import com.example.carrentalservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements IUserService {
    private final IUserClient client;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImplementation(IUserClient client, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.client = client;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;

        //User user = new User("motey","lal","motalal1@gmail.com","khai","iammotey1",122456,false);
        //user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        //client.createUser(user);

    }

    @Override
    public User createUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public User getUserByUserName(String userName) {
        try {
            User user = client.getUserByUserName(userName);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public AuthenticationResponse authenticate(LoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = client.getUserByUserName(request.getUsername());

        var jwtToken = jwtService.generateToken(user);
        System.out.println("jwt");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

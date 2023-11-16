package com.example.carrentalservice.service;

import com.example.carrentalservice.GrpcClient.IUserClient;
import com.example.carrentalservice.Jwt.JwtService;
import com.example.carrentalservice.Jwt.auth.AuthenticationResponse;
import com.example.carrentalservice.dto.LoginDto;
import com.example.carrentalservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements IUserService
{
    private final IUserClient client;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public UserServiceImplementation(IUserClient client, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.client = client;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
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
    public AuthenticationResponse authenticate(LoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getCpr(),
                        request.getPassword()
                )
        );
        var user = client.getUserByCprNumber(request.getCpr());

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

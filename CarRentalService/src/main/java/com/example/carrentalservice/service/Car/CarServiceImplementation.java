package com.example.carrentalservice.service.Car;


import com.example.carrentalservice.GrpcClient.Car.ICarClient;
import com.example.carrentalservice.dto.CarFilterDto;
import com.example.carrentalservice.model.Car;
import com.example.carrentalservice.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplementation implements ICarService
{
    private ICarClient client;

    public CarServiceImplementation( ICarClient client) {
        this.client = client;

    }

    @Override
    public Car createCar(Car car) {
        System.out.println("Creating car in CarServiceImpl.java: " + car.toString());
        try {
            return client.createCar(car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> getCars(CarFilterDto carFilterDto) {
        try {
            List<Car> cars = client.getCars(carFilterDto);
            return cars;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Car getCarById(int id) {
        try {
            return client.getCarById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
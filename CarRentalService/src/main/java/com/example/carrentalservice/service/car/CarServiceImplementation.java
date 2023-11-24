package com.example.carrentalservice.service.car;

import com.example.carrentalservice.GrpcClient.car.ICarClient;
import com.example.carrentalservice.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImplementation implements ICarService
{
    private ICarClient client;

    public CarServiceImplementation(ICarClient client) {
        this.client = client;
    }

    @Override
    public Car createCar(Car car) {
        try {
            return client.createCar(car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

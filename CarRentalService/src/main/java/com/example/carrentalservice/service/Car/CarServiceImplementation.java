package com.example.carrentalservice.service.Car;


import com.example.carrentalservice.model.Car;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImplementation implements ICarService
{
    private ICarService client;

    public CarServiceImplementation(@Lazy ICarService client) {
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
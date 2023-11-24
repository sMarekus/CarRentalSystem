package com.example.carrentalservice.GrpcClient.car;

import com.example.carrentalservice.model.Car;

public interface ICarClient
{
    Car createCar(Car car);
}

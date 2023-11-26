package com.example.carrentalservice.GrpcClient.Car;

import com.example.carrentalservice.model.Car;

public interface ICarClient
{
    Car createCar(Car car);
}
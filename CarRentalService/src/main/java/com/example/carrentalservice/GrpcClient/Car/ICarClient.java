package com.example.carrentalservice.GrpcClient.Car;

import com.example.carrentalservice.dto.CarFilterDto;
import com.example.carrentalservice.model.Car;

import java.util.List;

public interface ICarClient
{
    Car createCar(Car car);
    List<Car> getCars(CarFilterDto dto);
}
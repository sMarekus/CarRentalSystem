package com.example.carrentalservice.service.Car;
import com.example.carrentalservice.dto.CarFilterDto;
import com.example.carrentalservice.model.Car;
import com.example.carrentalservice.model.Enums.CarStatus;

import java.util.List;

public interface ICarService
{
    Car createCar(Car car);
    List<Car> getCars(CarFilterDto carFilterDto);

    Car getCarById(int id);
}
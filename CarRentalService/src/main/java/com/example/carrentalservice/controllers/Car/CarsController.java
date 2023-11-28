package com.example.carrentalservice.controllers.Car;

import com.example.carrentalservice.model.Car;
import com.example.carrentalservice.service.Car.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController
{
    private final ICarService carService;
    public CarsController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        System.out.println("Creating car in CarsController.java: " + car.toString());
        try{
            Car carFromDatabase = carService.createCar(car);
            System.out.println("car = " + car);
            return new ResponseEntity<>(carFromDatabase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
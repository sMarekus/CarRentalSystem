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
@CrossOrigin(origins = "http://localhost:8080")
public class CarsController
{
    private final ICarService carService;
    public CarsController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try{
            return new ResponseEntity<>(carService.createCar(car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
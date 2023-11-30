package com.example.carrentalservice.controllers.Car;

import com.example.carrentalservice.dto.CarFilterDto;
import com.example.carrentalservice.model.Car;
import com.example.carrentalservice.model.Enums.CarStatus;
import com.example.carrentalservice.service.Car.ICarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/cars")
    public ResponseEntity<List<Car>> getCars(@RequestParam(required = false) String brand,
                                             @RequestParam(required = false) String model,
                                             @RequestParam(required = false) String bodyType,
                                             @RequestParam(required = false) Integer horsePower,
                                             @RequestParam(required = false) String fuelType,
                                             @RequestParam(required = false) String gearbox,
                                             @RequestParam(required = false) String color,
                                             @RequestParam(required = false) String description,
                                             @RequestParam(required = false) Integer pricePerDay,
                                             @RequestParam(required = false) CarStatus status) {
        try {
            CarFilterDto dto=new CarFilterDto(brand, model, bodyType, horsePower, fuelType, gearbox, color,description, pricePerDay, status);


            System.out.println("dto = " + dto);

            List<Car> cars = carService.getCars(dto);

            System.out.println("cars = " + cars);


            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
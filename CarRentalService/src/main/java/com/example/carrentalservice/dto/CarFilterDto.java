package com.example.carrentalservice.dto;

import com.example.carrentalservice.model.Enums.CarStatus;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarFilterDto {


    private String brand;
    private String model;
    private String bodyType;
    private Integer horsePower;
    private String fuelType;
    private String gearbox;
    private String color;
    private String description;
    private Integer pricePerDay;
    private CarStatus status;
}

package com.example.carrentalservice.model;

import com.google.type.DateTime;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation
{
    private int id;
    private int carId;
    private int userId;
    private DateTime startDate;
    private DateTime endDate;
    private double totalPrice;
}

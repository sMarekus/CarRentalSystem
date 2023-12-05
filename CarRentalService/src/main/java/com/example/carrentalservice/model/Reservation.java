package com.example.carrentalservice.model;

import com.google.type.DateTime;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation
{
    private int Id;
    private int CarId;
    private int UserId;
    private LocalDateTime StartDate;
    private LocalDateTime EndDate;
    private double TotalPrice;
}

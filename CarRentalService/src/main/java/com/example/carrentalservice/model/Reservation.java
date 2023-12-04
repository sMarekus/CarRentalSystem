package com.example.carrentalservice.model;

import com.google.type.DateTime;

public class Reservation
{
    private int id;
    private int carId;
    private int userId;
    private DateTime startDate;
    private DateTime endDate;
    private User user;
}

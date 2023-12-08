package com.example.carrentalservice.service.Reservation;

import com.example.carrentalservice.model.Reservation;

import java.util.List;

public interface IReservationService
{
    Reservation createReservation(Reservation reservation);

    Reservation returnReservation(int id);

    List<Reservation> getReservations();
    Reservation getReservationById(int id);
    List<Reservation> getReservationsByCarId(int carId);
    List<Reservation> getReservationsByUserName(String userName);




}

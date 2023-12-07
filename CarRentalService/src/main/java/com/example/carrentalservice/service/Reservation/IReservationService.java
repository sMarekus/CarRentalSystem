package com.example.carrentalservice.service.Reservation;

import com.example.carrentalservice.model.Reservation;

import java.util.List;

public interface IReservationService
{
    Reservation createReservation(Reservation reservation);

    List<Reservation> getReservations();
    Reservation getReservationById(int id);


}

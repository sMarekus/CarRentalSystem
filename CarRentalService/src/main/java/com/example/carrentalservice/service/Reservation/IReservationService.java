package com.example.carrentalservice.service.Reservation;

import com.example.carrentalservice.model.Reservation;

public interface IReservationService
{
    Reservation createReservation(Reservation reservation);

    Reservation getReservationById(int id);
}

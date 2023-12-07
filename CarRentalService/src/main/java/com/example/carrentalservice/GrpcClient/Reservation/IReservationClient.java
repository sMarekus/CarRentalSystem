package com.example.carrentalservice.GrpcClient.Reservation;

import com.example.carrentalservice.model.Reservation;

public interface IReservationClient
{
    Reservation createReservation(Reservation reservation);
    Reservation getReservationById(int id);
}

package com.example.carrentalservice.GrpcClient.Reservation;

import com.example.carrentalservice.model.Reservation;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public interface IReservationClient
{
    Reservation createReservation(Reservation reservation);
    Reservation returnReservation(int id);

    List<Reservation> getReservations();
    Reservation getReservationById(int id);

    List<Reservation> getReservationsByCarId(int carId);
    List<Reservation> getReservationsByUserName(String userName);

}

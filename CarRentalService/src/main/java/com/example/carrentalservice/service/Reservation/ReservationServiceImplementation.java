package com.example.carrentalservice.service.Reservation;

import com.example.carrentalservice.GrpcClient.Reservation.IReservationClient;
import com.example.carrentalservice.model.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImplementation implements IReservationService

{
    private IReservationClient client;

    public ReservationServiceImplementation(IReservationClient client) {
        this.client = client;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        try {
            return client.createReservation(reservation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

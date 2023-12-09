package com.example.carrentalservice.service.Reservation;

import com.example.carrentalservice.GrpcClient.Reservation.IReservationClient;
import com.example.carrentalservice.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Reservation returnReservation(int id) {
        try {
            return client.returnReservation(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation cancelReservation(int id) {
        try {
            return client.cancelReservation(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservations() {
        try {
            return client.getReservations();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation getReservationById(int id) {
        try {
            return client.getReservationById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservationsByCarId(int carId) {
        try {
            return client.getReservationsByCarId(carId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> getReservationsByUserName(String userName) {
        try {
            return client.getReservationsByUserName(userName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.example.carrentalservice.controllers.Reservation;

import com.example.carrentalservice.service.Reservation.IReservationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationsController
{
    private IReservationService reservationService;
    public ReservationsController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

}
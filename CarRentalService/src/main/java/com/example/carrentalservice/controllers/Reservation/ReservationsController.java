package com.example.carrentalservice.controllers.Reservation;

import com.example.carrentalservice.model.Reservation;
import com.example.carrentalservice.service.Reservation.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationsController
{
    private IReservationService reservationService;
    public ReservationsController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation)
    {
        try {
            Reservation reservationFromDatabase = reservationService.createReservation(reservation);
            return new ResponseEntity<>(reservationFromDatabase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

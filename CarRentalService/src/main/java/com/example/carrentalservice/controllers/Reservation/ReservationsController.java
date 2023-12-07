package com.example.carrentalservice.controllers.Reservation;

import com.example.carrentalservice.model.Reservation;
import com.example.carrentalservice.service.Reservation.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationsController
{
    private final IReservationService reservationService;
    public ReservationsController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation)
    {
        System.out.println("Received reservation: " + reservation);
        try {
            Reservation reservationFromDatabase = reservationService.createReservation(reservation);
            return new ResponseEntity<>(reservationFromDatabase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/reservations")
    public ResponseEntity<List<Reservation>> getReservations()
    {
        try {
            List<Reservation> reservations = reservationService.getReservations();
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") int id)
    {
        System.out.println("Received reservation id: " + id);
        try {
            Reservation reservationFromDatabase = reservationService.getReservationById(id);
            return new ResponseEntity<>(reservationFromDatabase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

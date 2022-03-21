package com.example.adventurebackend.controller;

import com.example.adventurebackend.model.Booking;
import com.example.adventurebackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    /**
     * Get a list of all bookings in the system
     *
     * @return list of bookings
     * @author Jackie
     */
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Create a booking, get a request body in json. send data to database
     * and save the booking object in database.
     *
     * @param booking data containing booking object
     * @return Entity
     * @author Jackie
     */
    @PostMapping("/create/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Update a booking, by id of the booking that needs update, and update
     * with new request-body.
     *
     * @param id      booking id
     * @param booking booking object with updated information
     * @return a Entity with complete msg
     * @author Jackie
     */
    @PutMapping("/update/booking/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        booking.setBookingId(id); // set same id on obj
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.save(booking);
            return new ResponseEntity<>("Updated Booking by id = " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed by id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a booking, with given id, and remove it from the database
     *
     * @param id booking id
     * @return an Entity with msg
     * @author Jackie
     */
    @DeleteMapping("/delete/booking/{id}")
    public ResponseEntity<String> deleteCounty(@PathVariable int id) {
        try {
            bookingRepository.deleteById(id);
            return new ResponseEntity<>("deleted booking by id = " + id, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>("can't delete booking by id = " + id, HttpStatus.NOT_FOUND);
        }
    }

}

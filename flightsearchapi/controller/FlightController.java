package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.Flight;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Tüm uçuşları listeleme
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Belirli bir ID'ye sahip uçuşu getirme
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Yeni uçuş ekleme
    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    // Uçuş güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            Flight updatedFlight = flight.get();
            // Burada diğer alanları da güncelleyebilirsiniz.
            // Örnek olarak sadece fiyatı güncelledim.
            updatedFlight.setPrice(flightDetails.getPrice());
            flightService.updateFlight(updatedFlight);
            return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Uçuş silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            flightService.deleteFlight(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

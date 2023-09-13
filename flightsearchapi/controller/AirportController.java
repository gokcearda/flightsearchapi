package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    // Tüm havaalanlarını listeleme
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // Belirli bir ID'ye sahip havaalanını getirme
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        if (airport.isPresent()) {
            return new ResponseEntity<>(airport.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Yeni havaalanı ekleme
    @PostMapping
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        Airport savedAirport = airportService.addAirport(airport);
        return new ResponseEntity<>(savedAirport, HttpStatus.CREATED);
    }

    // Havaalanı güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airportDetails) {
        Optional<Airport> airport = airportService.getAirportById(id);
        if (airport.isPresent()) {
            Airport updatedAirport = airport.get();
            updatedAirport.setCity(airportDetails.getCity());
            airportService.updateAirport(updatedAirport);
            return new ResponseEntity<>(updatedAirport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Havaalanı silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        if (airport.isPresent()) {
            airportService.deleteAirport(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

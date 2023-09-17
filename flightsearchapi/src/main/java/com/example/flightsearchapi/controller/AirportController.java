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

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
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

}

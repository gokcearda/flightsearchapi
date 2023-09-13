package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Flight;
import com.example.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Tüm uçuşları listeleme
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Belirli bir ID'ye sahip uçuşu getirme
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Yeni uçuş ekleme
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Uçuş güncelleme
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Uçuş silme
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}

package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    // Tüm havaalanlarını listeleme
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Belirli bir ID'ye sahip havaalanını getirme
    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    // Yeni havaalanı ekleme
    public Airport addAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Havaalanı güncelleme
    public Airport updateAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Havaalanı silme
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}

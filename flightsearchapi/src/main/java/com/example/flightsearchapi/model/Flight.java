package com.example.flightsearchapi.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {
    public void setId(Long id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_datetime", nullable = false)
    private LocalDateTime departureDatetime;

    @Column(name = "return_datetime")
    private LocalDateTime returnDatetime;

    @Column(nullable = false)
    private BigDecimal price;

}

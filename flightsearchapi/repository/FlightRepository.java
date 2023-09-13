import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightsearchapi.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}

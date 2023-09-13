import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightsearchapi.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}

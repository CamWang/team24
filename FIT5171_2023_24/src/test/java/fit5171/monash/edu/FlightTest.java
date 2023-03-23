package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

public class FlightTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testConstructor() {
        Flight flight = new Flight();
        assertNotNull(flight);
    }

    @Test
    public void testSetterMethods() {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);

        flight.setFlightID(3);
        flight.setDepartTo("Melbourne");
        flight.setDepartFrom("Sydney");
        flight.setCode("QF002");
        flight.setCompany("Qantas");
        flight.setDateFrom(Timestamp.valueOf("2023-6-7 12:00:00"));
        flight.setDateTo(Timestamp.valueOf("2023-6-7 15:00:00"));
        flight.setAirplane(airplane);

        assertEquals(3, flight.getFlightID());
        assertEquals("Melbourne", flight.getDepartTo());
        assertEquals("Sydney", flight.getDepartFrom());
        assertEquals("QF002", flight.getCode());
        assertEquals("Qantas", flight.getCompany());
        assertEquals(Timestamp.valueOf("2023-6-7 12:00:00"), flight.getDateFrom());
        assertEquals(Timestamp.valueOf("2023-6-7 15:00:00"), flight.getDateTo());
        assertEquals(airplane, flight.getAirplane());
    }

    @Test
    public void testToStringMethod() {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);

        String expectedString = "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}";
        assertEquals(expectedString, flight.toString());
    }


}

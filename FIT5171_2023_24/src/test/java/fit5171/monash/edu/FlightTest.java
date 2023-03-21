package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

public class FlightTest {
    private Airplane airplane;
    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    void setUp() {
        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight1 = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
        flight2 = new Flight(2, "Melbourne", "Taipei", "EA001", "Evaair", Timestamp.valueOf("2023-6-9 12:00:00"),
                Timestamp.valueOf("2023-6-9 15:00:00"), airplane);
    }

    @Test
    public void testGetterMethods() {
        assertEquals(1, flight1.getFlightID());
        assertEquals("Sydney", flight1.getDepartTo());
        assertEquals("Melbourne", flight1.getDepartFrom());
        assertEquals("QF001", flight1.getCode());
        assertEquals("Qantas", flight1.getCompany());
        assertEquals(Timestamp.valueOf("2023-6-8 12:00:00"), flight1.getDateFrom());
        assertEquals(Timestamp.valueOf("2023-6-8 15:00:00"), flight1.getDateTo());
        assertEquals(airplane, flight1.getAirplane());
    }

    @Test
    public void testSetterMethods() {
        flight1.setFlightID(3);
        flight1.setDepartTo("Melbourne");
        flight1.setDepartFrom("Sydney");
        flight1.setCode("QF002");
        flight1.setCompany("Qantas");
        flight1.setDateFrom(Timestamp.valueOf("2023-6-7 12:00:00"));
        flight1.setDateTo(Timestamp.valueOf("2023-6-7 15:00:00"));
        flight1.setAirplane(airplane);

        assertEquals(3, flight1.getFlightID());
        assertEquals("Melbourne", flight1.getDepartTo());
        assertEquals("Sydney", flight1.getDepartFrom());
        assertEquals("QF002", flight1.getCode());
        assertEquals("Qantas", flight1.getCompany());
        assertEquals(Timestamp.valueOf("2023-6-7 12:00:00"), flight1.getDateFrom());
        assertEquals(Timestamp.valueOf("2023-6-7 15:00:00"), flight1.getDateTo());
        assertEquals(airplane, flight1.getAirplane());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-09 15:00:00.0, ', date from='2023-06-09 12:00:00.0', depart from='Taipei', depart to='Melbourne', code=EA001', company=Evaair', code=EA001'}";
        assertEquals(expectedString, flight2.toString());
    }

}

package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class FlightTest {
    private Airplane airplane;
    private Flight flight;

    @BeforeEach
    void setUp() {
        airplane = mock(Airplane.class);
        when(airplane.getAirplaneID()).thenReturn(1);
        when(airplane.getAirplaneModel()).thenReturn("Boeing 747");
        when(airplane.getBusinessSitsNumber()).thenReturn(10);
        when(airplane.getEconomySitsNumber()).thenReturn(200);
        when(airplane.getCrewSitsNumber()).thenReturn(5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
    }

    @Test
    public void testConstructor() {
        Flight flight = new Flight();
        assertNotNull(flight);
    }

    @Test
    public void testSetterMethods() throws ParseException {
        flight.setFlightID(3);
        flight.setDepartTo("Melbourne");
        flight.setDepartFrom("Sydney");
        flight.setCode("QF002");
        flight.setCompany("Qantas");
        flight.setDateFrom("07/06/23 12:00:00");
        flight.setDateTo("07/06/23 15:00:00");
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
        when(airplane.toString()).thenReturn("Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}");
        String expectedString = "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}";
        assertEquals(expectedString, flight.toString());
    }

    @Test
    public void dateFromIncorrectFormat() throws IllegalArgumentException, ParseException {
        try {
            flight.setDateFrom("2023-6-7 12:00:00");
        } catch (IllegalArgumentException e) {
            assertEquals("Date format must be DD/MM/YY", e.getMessage());
        }
        try {
            flight.setDateFrom("08/06/23 12-00-00");
        } catch (IllegalArgumentException e) {
            assertEquals("Time format must be HH:MM:SS", e.getMessage());
        }
    }

    @Test
    public void dateToIncorrectFormat() throws IllegalArgumentException, ParseException {
        try {
            flight.setDateTo("2023-6-7 12:00:00");
        } catch (IllegalArgumentException e) {
            assertEquals("Date format must be DD/MM/YY", e.getMessage());
        }
        try {
            flight.setDateTo("08/06/23 12-00-00");
        } catch (IllegalArgumentException e) {
            assertEquals("Time format must be HH:MM:SS", e.getMessage());
        }
    }
    @Test
    public void addExistFlightID() throws IllegalArgumentException {
        try {
            Flight newFlight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                    Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
        } catch (IllegalArgumentException e) {
            assertEquals("Flight ID already exists", e.getMessage());
        }
    }
}

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
    private Airplane mockAirplane;
    private Flight flight;

    @BeforeEach
    void setUp() throws ParseException {
        mockAirplane = mock(Airplane.class);
        when(mockAirplane.getAirplaneID()).thenReturn(1);
        when(mockAirplane.getAirplaneModel()).thenReturn("Boeing 747");
        when(mockAirplane.getBusinessSitsNumber()).thenReturn(10);
        when(mockAirplane.getEconomySitsNumber()).thenReturn(200);
        when(mockAirplane.getCrewSitsNumber()).thenReturn(5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", mockAirplane);
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
        flight.setAirplane(mockAirplane);

        assertEquals(3, flight.getFlightID());
        assertEquals("Melbourne", flight.getDepartTo());
        assertEquals("Sydney", flight.getDepartFrom());
        assertEquals("QF002", flight.getCode());
        assertEquals("Qantas", flight.getCompany());
        assertEquals("07/06/23 12:00:00", flight.getDateFrom());
        assertEquals("07/06/23 15:00:00", flight.getDateTo());
        assertEquals(mockAirplane, flight.getAirplane());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Flight{" + mockAirplane.toString() + ", date to=08/06/23 15:00:00, ', date from='08/06/23 12:00:00', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}";
        assertEquals(expectedString, flight.toString());
    }

    @Test
    public void dateFromInvalidFormat() throws IllegalArgumentException, ParseException {
        try {
            flight.setDateFrom("2023-6-7 12:00:00");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Date format must be DD/MM/YY", e.getMessage());
        }
        try {
            flight.setDateFrom("08/06/23 12-00-00");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Time format must be HH:MM:SS", e.getMessage());
        }
    }

    @Test
    public void dateFromValidFormat() throws ParseException {
        flight.setDateFrom("08/06/23 12:00:00");
        assertEquals("08/06/23 12:00:00", flight.getDateFrom());
    }

    @Test
    public void dateToInvalidFormat() throws IllegalArgumentException, ParseException {
        try {
            flight.setDateTo("2023-6-7 12:00:00");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Date format must be DD/MM/YY", e.getMessage());
        }
        try {
            flight.setDateTo("08/06/23 12-00-00");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Time format must be HH:MM:SS", e.getMessage());
        }
    }

    @Test
    public void dateToValidFormat() throws ParseException {
        flight.setDateTo("08/06/23 12:00:00");
        assertEquals("08/06/23 12:00:00", flight.getDateTo());
    }
//    @Test
//    public void addExistFlightID() throws IllegalArgumentException {
//        try {
//            Flight newFlight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
//                    Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
//            fail("Expected IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Flight ID already exists", e.getMessage());
//        }
//    }
}

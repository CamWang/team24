package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    void setUp() {
        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
    }

    @Test
    public void testSetterMethods() {
        airplane.setAirplaneID(3);
        airplane.setAirplaneModel("Airbus A380");
        airplane.setBusinessSitsNumber(20);
        airplane.setEconomySitsNumber(100);
        airplane.setCrewSitsNumber(10);

        assertEquals(3, airplane.getAirplaneID());
        assertEquals("Airbus A380", airplane.getAirplaneModel());
        assertEquals(20, airplane.getBusinessSitsNumber());
        assertEquals(100, airplane.getEconomySitsNumber());
        assertEquals(10, airplane.getCrewSitsNumber());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}";
        assertEquals(expectedString, airplane.toString());
    }

//    @Test
//    public void testGetAirPlaneInfo() {
//        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
//                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
//
//        FlightCollection.flights = new ArrayList<Flight>();
//        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
//        FlightCollection.addFlights(flights_db);
//
//        assertEquals(airplane, airplane.getAirPlaneInfo(1));
//    }

    @Test
    public void businessSeatNumberNotInRange() throws IllegalArgumentException {
        try {
            airplane.setBusinessSitsNumber(0);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Business sits number cannot be less than 1"));
        }
        try {
            airplane.setBusinessSitsNumber(400);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Business sits number cannot be greater than 300"));
        }
    }

    @Test
    public void businessSeatNumberInRange() {
        airplane.setBusinessSitsNumber(1);
        assertEquals(1, airplane.getBusinessSitsNumber());
    }

    @Test
    public void economySeatNumberNotInRange() throws IllegalArgumentException {
        try {
            airplane.setEconomySitsNumber(0);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Economy sits number cannot be less than 1"));
        }
        try {
            airplane.setEconomySitsNumber(400);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Economy sits number cannot be greater than 300"));
        }
    }
    @Test
    public void economySeatNumberInRange() {
        airplane.setEconomySitsNumber(1);
        assertEquals(1, airplane.getEconomySitsNumber());
    }
    @Test
    public void crewSeatNumberNotInRange() throws IllegalArgumentException {
        try {
            airplane.setCrewSitsNumber(0);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Crew sits number cannot be less than 1"));
        }
        try {
            airplane.setCrewSitsNumber(400);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Crew sits number cannot be greater than 300"));
        }
    }
    @Test
    public void crewSeatNumberInRange() {
        airplane.setCrewSitsNumber(1);
        assertEquals(1, airplane.getCrewSitsNumber());
    }
}

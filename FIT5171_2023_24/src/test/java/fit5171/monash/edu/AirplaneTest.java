package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testSetterMethods() {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);

        airplane.setAirplaneID(3);
        airplane.setAirplaneModel("Airbus A380");
        airplane.setBusinessSitsNumber(20);
        airplane.setEconomySitsNumber(400);
        airplane.setCrewSitsNumber(10);

        assertEquals(3, airplane.getAirplaneID());
        assertEquals("Airbus A380", airplane.getAirplaneModel());
        assertEquals(20, airplane.getBusinessSitsNumber());
        assertEquals(400, airplane.getEconomySitsNumber());
        assertEquals(10, airplane.getCrewSitsNumber());
    }

    @Test
    public void testToStringMethod() {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        String expectedString = "Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}";
        assertEquals(expectedString, airplane.toString());
    }

    @Test
    public void testGetAirPlaneInfo() {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);

        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);

        assertEquals(airplane, airplane.getAirPlaneInfo(1));
    }

}

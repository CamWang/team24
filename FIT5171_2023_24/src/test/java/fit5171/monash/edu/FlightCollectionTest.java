package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;

public class FlightCollectionTest {
    private Airplane airplane;
    private Flight flight;
    @BeforeEach
    public void setUp() throws ParseException {
        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
    }

    @Test
    void testGetFlight() {
        FlightCollection.flights = new ArrayList<Flight>();
        assertEquals(FlightCollection.flights, FlightCollection.getFlights());
    }

    @Test
    void testAddFlights() {
        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);
        assertEquals(flights_db, FlightCollection.getFlights());
    }

    @Test
    void testGetFlightInfoWithTwoCities() {
        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);
        assertEquals(flight, FlightCollection.getFlightInfo("Melbourne", "Sydney"));
    }

    @Test
    void testGetFlightInfoWithCity() {
        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);
        assertEquals(flight, FlightCollection.getFlightInfo("Sydney"));
    }

    @Test
    void testGetFlightInfoWithFlight_id() {
        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);
        assertEquals(flight, FlightCollection.getFlightInfo(1));
    }

}

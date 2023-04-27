package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    private Airplane mockAirplane;
    private ArrayList<Flight> mockFlights;
    private Flight mockFlight;
    @BeforeEach
    public void setUp() {
        mockFlights = new ArrayList<Flight>();
        mockFlight = mock(Flight.class);
        mockFlights.add(mockFlight);

        FlightCollection.flights = mockFlights;
    }

    @Test
    void testGetFlights() {
        assertEquals(mockFlights, FlightCollection.getFlights());
    }

    @Test
    void testAddFlights() {
        assertEquals(mockFlights, FlightCollection.getFlights());
    }

    @Test
    void testAddExistFlights() {
        when(mockFlight.getFlightID()).thenReturn(1);
        try{
            FlightCollection.addFlights(mockFlights);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Flight already exists", e.getMessage());
        }
    }


    @Test
    void testGetFlightInfoWithTwoCities() {
        when(mockFlight.getDepartFrom()).thenReturn("Melbourne");
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        assertEquals(mockFlight, FlightCollection.getFlightInfo("Melbourne", "Sydney"));
    }

    @Test
    public void testGetFlightInfoWithInvalidTwoCities() {
        when(mockFlight.getDepartFrom()).thenReturn("Melbourne");
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        Flight result = FlightCollection.getFlightInfo("123", "456");
        assertNull(result);
    }

    @Test
    void testGetFlightInfoWithCity() {
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        assertEquals(mockFlight, FlightCollection.getFlightInfo("Sydney"));
    }
    @Test
    public void testGetFlightInfoWithInvalidCity() {
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        Flight result = FlightCollection.getFlightInfo("123");
        assertNull(result);
    }


    @Test
    void testGetFlightInfoWithFlight_id() {
        when(mockFlight.getFlightID()).thenReturn(1);
        assertEquals(mockFlight, FlightCollection.getFlightInfo(1));
    }
    @Test
    public void testGetFlightInfoWithInvalidFlight_id() {
        when(mockFlight.getFlightID()).thenReturn(1);
        Flight result = FlightCollection.getFlightInfo(9);
        assertNull(result);
    }
}

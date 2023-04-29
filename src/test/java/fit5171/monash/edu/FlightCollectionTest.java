package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class FlightCollectionTest {
    @Mock
    private ArrayList<Flight> mockFlights;
    @Mock
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

    /**
     * 1. When adding a flight into the system,
     * test if it conforms with the requirement as a flight and Flight Collection.
     */
    @Test
    void testAddExistFlights() {
        when(mockFlight.getFlightID()).thenReturn(1);
        try {
            FlightCollection.addFlights(mockFlights);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Flight already exists", e.getMessage());
        }
    }

    /**
     * 2. Valid city names must be used.
     */
    @Test
    void testAddInvalidCityFlights() {
        when(mockFlight.getFlightID()).thenReturn(1).thenReturn(2);
        when(mockFlight.getDepartTo()).thenReturn("Sydney123");
        when(mockFlight.getDepartFrom()).thenReturn("Melbourne");
        try {
            FlightCollection.addFlights(mockFlights);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("City can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    void testGetFlightInfoWithTwoCities() {
        when(mockFlight.getDepartFrom()).thenReturn("Melbourne");
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        assertEquals(mockFlight, FlightCollection.getFlightInfo("Melbourne", "Sydney"));
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    public void testGetFlightInfoWithInvalidTwoCities() {
        when(mockFlight.getDepartFrom()).thenReturn("Melbourne");
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        Flight result = FlightCollection.getFlightInfo("123", "456");
        assertNull(result);
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    void testGetFlightInfoWithCity() {
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        assertEquals(mockFlight, FlightCollection.getFlightInfo("Sydney"));
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    public void testGetFlightInfoWithInvalidCity() {
        when(mockFlight.getDepartTo()).thenReturn("Sydney");
        Flight result = FlightCollection.getFlightInfo("123");
        assertNull(result);
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    void testGetFlightInfoWithFlight_id() {
        when(mockFlight.getFlightID()).thenReturn(1);
        assertEquals(mockFlight, FlightCollection.getFlightInfo(1));
    }

    /**
     * 3. When trying to get flight information, a valid flight is returned.
     */
    @Test
    public void testGetFlightInfoWithInvalidFlight_id() {
        when(mockFlight.getFlightID()).thenReturn(1);
        Flight result = FlightCollection.getFlightInfo(9);
        assertNull(result);
    }
}

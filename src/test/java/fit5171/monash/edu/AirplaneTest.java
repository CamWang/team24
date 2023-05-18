package fit5171.monash.edu;

import fit5171.monash.edu.entity.Airplane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {
    Airplane airplane = new Airplane();

    @BeforeEach
    void setUp() {
        this.airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
    }

    /**
     * 1. Ensure all fields/details for an airplane like Airplane ID, Airplane businessSitsNumber,
     * crewSitsNumber, etc. are tested
     */
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

    /**
     * 2. Seat number must be in the range [1, 300].
     */
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

    /**
     * 2. Seat number must be in the range [1, 300].
     */
    @Test
    public void businessSeatNumberInRange() {
        airplane.setBusinessSitsNumber(1);
        assertEquals(1, airplane.getBusinessSitsNumber());
    }

    /**
     * 2. Seat number must be in the range [1, 300].
     */
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

    /**
     * 2. Seat number must be in the range [1, 300].
     */
    @Test
    public void economySeatNumberInRange() {
        airplane.setEconomySitsNumber(1);
        assertEquals(1, airplane.getEconomySitsNumber());
    }

    /**
     * 2. Seat number must be in the range [1, 300].
     */
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

    /**
     * 2. Seat number must be in the range [1, 300].
     */
    @Test
    public void crewSeatNumberInRange() {
        airplane.setCrewSitsNumber(1);
        assertEquals(1, airplane.getCrewSitsNumber());
    }
}

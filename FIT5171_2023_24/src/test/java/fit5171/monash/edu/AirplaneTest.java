package fit5171.monash.edu;

// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest {
    private Airplane airplane1;
    private Airplane airplane2;

    @BeforeEach
    void setUp() {
        airplane1 = new Airplane(1, "Boeing 747", 10, 200, 5);
        airplane2 = new Airplane(2, "Boeing 747", 10, 200, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(1, this.airplane1.getAirplaneID());
        assertEquals("Boeing 747", airplane1.getAirplaneModel());
        assertEquals(10, airplane1.getBusinessSitsNumber());
        assertEquals(200, airplane1.getEconomySitsNumber());
        assertEquals(5, airplane1.getCrewSitsNumber());
    }



    @Test
    public void testSetterMethods() {
        airplane1.setAirplaneID(3);
        assertEquals(3, airplane1.getAirplaneID());
        airplane1.setAirplaneModel("Airbus A380");
        assertEquals("Airbus A380", airplane1.getAirplaneModel());
        airplane1.setBusinessSitsNumber(20);
        assertEquals(20, airplane1.getBusinessSitsNumber());
        airplane1.setEconomySitsNumber(400);
        assertEquals(400, airplane1.getEconomySitsNumber());
        airplane1.setCrewSitsNumber(10);
        assertEquals(10, airplane1.getCrewSitsNumber());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}";
        assertEquals(expectedString, airplane2.toString());
    }

}

package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testConstructor() {
        Passenger passenger = new Passenger();
        assertNotNull(passenger);
    }

    @Test
    public void testSetterMethods() {
        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);

        passenger.setFirstName("MingZe");
        passenger.setSecondName("Li");
        passenger.setAge(28);
        passenger.setGender("female");
        passenger.setEmail("mlii0181@student.monash.edu");
        passenger.setPhoneNumber("0450000001");
        passenger.setPassport("987654321");
        passenger.setCardNumber("987654321");
        passenger.setSecurityCode(321);

        assertEquals("MingZe", passenger.getFirstName());
        assertEquals("Li", passenger.getSecondName());
        assertEquals(28, passenger.getAge());
        assertEquals("female", passenger.getGender());
        assertEquals("mlii0181@student.monash.edu", passenger.getEmail());
        assertEquals("0450000001", passenger.getPhoneNumber());
        assertEquals("987654321", passenger.getPassport());
        assertEquals("987654321", passenger.getCardNumber());
        assertEquals(321, passenger.getSecurityCode());
    }

    @Test
    public void testToStringMethod() {
        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
        String expectedString = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450000000', passport='123456789}";
        assertEquals(expectedString, passenger.toString());
    }
}

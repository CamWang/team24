package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
        passenger2 = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
    }

    @Test
    public void TestGetterMethods() {
        assertEquals("Wells", passenger1.getFirstName());
        assertEquals("Yu", passenger1.getSecondName());
        assertEquals(27, passenger1.getAge());
        assertEquals("male", passenger1.getGender());
        assertEquals("cyuu0052@student.monash.edu", passenger1.getEmail());
        assertEquals("0450000000", passenger1.getPhoneNumber());
        assertEquals("123456789", passenger1.getPassport());
        assertEquals("123456789", passenger1.getCardNumber());
        assertEquals(123, passenger1.getSecurityCode());
    }

    @Test
    public void testSetterMethods() {
        passenger2.setFirstName("MingZe");
        passenger2.setSecondName("Li");
        passenger2.setAge(28);
        passenger2.setGender("female");
        passenger2.setEmail("mlii0181@student.monash.edu");
        passenger2.setPhoneNumber("0450000001");
        passenger2.setPassport("987654321");
        passenger2.setCardNumber("987654321");
        passenger2.setSecurityCode(321);

        assertEquals("MingZe", passenger2.getFirstName());
        assertEquals("Li", passenger2.getSecondName());
        assertEquals(28, passenger2.getAge());
        assertEquals("female", passenger2.getGender());
        assertEquals("mlii0181@student.monash.edu", passenger2.getEmail());
        assertEquals("0450000001", passenger2.getPhoneNumber());
        assertEquals("987654321", passenger2.getPassport());
        assertEquals("987654321", passenger2.getCardNumber());
        assertEquals(321, passenger2.getSecurityCode());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450 000 000', passport='123456789}";
        assertEquals(expectedString, passenger1.toString());
    }
}

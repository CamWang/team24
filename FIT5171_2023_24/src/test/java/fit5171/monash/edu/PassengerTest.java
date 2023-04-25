package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PassengerTest {
    private Person person;
    private Passenger passenger;
    @BeforeEach
    void setUp() {
        person = mock(Person.class);
        passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
    }

    @Test
    public void testConstructor() {
        Passenger passenger = new Passenger();
        assertNotNull(passenger);
    }

    @Test
    public void testSetterMethods() {
        passenger.setFirstName("MingZe");
        passenger.setSecondName("Li");
        passenger.setAge(28);
        passenger.setGender("Non-binary|gender diverse");
        passenger.setEmail("mlii0181@student.monash.edu");
        passenger.setPhoneNumber("0450000001");
        passenger.setPassport("987654321");
        passenger.setCardNumber("987654321");
        passenger.setSecurityCode(321);

        assertEquals("MingZe", passenger.getFirstName());
        assertEquals("Li", passenger.getSecondName());
        assertEquals(28, passenger.getAge());
        assertEquals("Non-binary|gender diverse", passenger.getGender());
        assertEquals("mlii0181@student.monash.edu", passenger.getEmail());
        assertEquals("0450000001", passenger.getPhoneNumber());
        assertEquals("987654321", passenger.getPassport());
        assertEquals("987654321", passenger.getCardNumber());
        assertEquals(321, passenger.getSecurityCode());
    }

    @Test
    public void testToStringMethod() {
        when(person.getFirstName()).thenReturn("Wells");
        when(person.getSecondName()).thenReturn("Yu");
        String expectedString = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450000000', passport='123456789}";
        assertEquals(expectedString, passenger.toString());
    }

    @Test
    public void genderInvalidFormat() throws IllegalArgumentException{
        try {
            passenger.setGender("Male");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.", e.getMessage());
        }
    }
    @Test
    public void firstNameInvalidFormat() throws IllegalArgumentException{
        try {
            passenger.setFirstName("1Wells");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }
}

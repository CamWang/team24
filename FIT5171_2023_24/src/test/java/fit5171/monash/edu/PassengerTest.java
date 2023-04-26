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
        passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.com", "0450000000",
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
        passenger.setEmail("mlii0181@student.monash.com");
        passenger.setPhoneNumber("0450000001");
        passenger.setPassport("987654321");
        passenger.setCardNumber("987654321");
        passenger.setSecurityCode(321);

        assertEquals("MingZe", passenger.getFirstName());
        assertEquals("Li", passenger.getSecondName());
        assertEquals(28, passenger.getAge());
        assertEquals("Non-binary|gender diverse", passenger.getGender());
        assertEquals("mlii0181@student.monash.com", passenger.getEmail());
        assertEquals("0450000001", passenger.getPhoneNumber());
        assertEquals("987654321", passenger.getPassport());
        assertEquals("987654321", passenger.getCardNumber());
        assertEquals(321, passenger.getSecurityCode());
    }

    @Test
    public void testToStringMethod() {
        when(person.getFirstName()).thenReturn("Wells");
        when(person.getSecondName()).thenReturn("Yu");
        String expectedString = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.com', phoneNumber='0450000000', passport='123456789}";
        assertEquals(expectedString, passenger.toString());
    }

    @Test
    public void genderValidFormat() {
        passenger.setGender("Man");
        assertEquals("Man", passenger.getGender());
    }

    @Test
    public void genderInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setGender("Male");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.", e.getMessage());
        }
    }

    @Test
    public void firstNameValidFormat() {
        passenger.setFirstName("Wells");
        assertEquals("Wells", passenger.getFirstName());
    }

    @Test
    public void firstNameInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setFirstName("1Wells");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }

    @Test
    public void secondNameValidFormat() {
        passenger.setSecondName("Wells");
        assertEquals("Wells", passenger.getSecondName());
    }

    @Test
    public void secondNameInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setSecondName("1Wells");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }

    @Test
    public void phoneNumberValidFormat() {
        passenger.setPhoneNumber("0412345678");
        assertEquals("0412345678", passenger.getPhoneNumber());
    }

    @Test
    public void phoneNumberInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setPhoneNumber("041234567");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong phone number format", e.getMessage());
        }
        try {
            passenger.setPhoneNumber("0612345678");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong phone number format", e.getMessage());
        }
        try {
            passenger.setPhoneNumber("+6112345678");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong phone number format", e.getMessage());
        }
    }

    @Test
    public void emailValidFormat() {
        passenger.setEmail("abc@domain.com");
        assertEquals("abc@domain.com", passenger.getEmail());
    }

    @Test
    public void emailInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setEmail("abc@domain.co");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong email format", e.getMessage());
        }
    }

    @Test
    public void passportNumberValidFormat() {
        passenger.setPassport("123456789");
        assertEquals("123456789", passenger.getPassport());
    }

    @Test
    public void passportNumberInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setPassport("1234567890");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong passport number format", e.getMessage());
        }
        try {
            passenger.setPassport("A23456789");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong passport number format", e.getMessage());
        }
    }
}

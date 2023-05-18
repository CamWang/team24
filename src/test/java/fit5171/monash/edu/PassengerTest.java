package fit5171.monash.edu;

import fit5171.monash.edu.entity.Passenger;
import fit5171.monash.edu.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PassengerTest {
    @Mock
    private Person mockPerson;
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        mockPerson = mock(Person.class);
        passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.com", "0450000000",
                "123456789", "123456789", 123);
    }

    /**
     * 1. All fields of a passenger are required.
     * Note: Mock the behavior of the Person class while creating objects of the Passenger class for unit testing.
     * 5. When a passenger is being added, it must include the passenger’s First name, Last Name, age,
     * and gender following the person who is becoming a passenger
     */
    @Test
    public void testConstructor() {
        when(mockPerson.getFirstName()).thenReturn("Wells");
        when(mockPerson.getSecondName()).thenReturn("Yu");
        when(mockPerson.getAge()).thenReturn(27);
        when(mockPerson.getGender()).thenReturn("Man");
        Passenger passenger = new Passenger(mockPerson.getFirstName(), mockPerson.getSecondName(), mockPerson.getAge(),
                mockPerson.getGender());
        assertEquals("Wells", passenger.getFirstName());
        assertEquals("Yu", passenger.getSecondName());
        assertEquals(27, passenger.getAge());
        assertEquals("Man", passenger.getGender());
    }

    /**
     * 1. All fields of a passenger are required.
     * Note: Mock the behavior of the Person class while creating objects of the Passenger class for unit testing.
     */
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
        when(mockPerson.getFirstName()).thenReturn("Wells");
        when(mockPerson.getSecondName()).thenReturn("Yu");
        String expectedString = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.com', phoneNumber='0450000000', passport='123456789}";
        assertEquals(expectedString, passenger.toString());
    }

    /**
     * 2. Phone number follows a pattern. Within Australia,
     * mobile phone numbers begin with 04 or 05 – the Australian national trunk code" 0,
     * plus the mobile indicator 4 or 5, then followed by eight digits.
     * This is generally written as 04XX XXX XXX within Australia or as +61 4XX XXX XXX for an international audience.
     */
    @Test
    public void phoneNumberValidFormat() {
        passenger.setPhoneNumber("0412345678");
        assertEquals("0412345678", passenger.getPhoneNumber());
    }

    /**
     * 2. Phone number follows a pattern. Within Australia,
     * mobile phone numbers begin with 04 or 05 – the Australian national trunk code" 0,
     * plus the mobile indicator 4 or 5, then followed by eight digits.
     * This is generally written as 04XX XXX XXX within Australia or as +61 4XX XXX XXX for an international audience.
     */
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

    /**
     * 3. The email follows a valid pattern “abc@domain.com”.
     */
    @Test
    public void emailValidFormat() {
        passenger.setEmail("abc@domain.com");
        assertEquals("abc@domain.com", passenger.getEmail());
    }

    /**
     * 3. The email follows a valid pattern “abc@domain.com”.
     */
    @Test
    public void emailInvalidFormat() throws IllegalArgumentException {
        try {
            passenger.setEmail("abc@domain.co");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong email format", e.getMessage());
        }
    }

    /**
     * 4. The passport number should not be more than 9 characters long.
     */
    @Test
    public void passportNumberValidFormat() {
        passenger.setPassport("123456789");
        assertEquals("123456789", passenger.getPassport());
    }

    /**
     * 4. The passport number should not be more than 9 characters long.
     */
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

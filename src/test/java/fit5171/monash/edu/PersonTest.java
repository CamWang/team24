package fit5171.monash.edu;

import fit5171.monash.edu.entity.Passenger;
import fit5171.monash.edu.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Passenger("null", "null", 1, "Other");
    }

//    @Test
//    public void testConstructor() {
//        assertNotNull(person);
//    }

    /**
     * 1. All fields of a Person class are required to create a person.
     */
    @Test
    void testAllFields() {
        person = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.com", "0450000000", "123456789", "123456789", 123);
        assertEquals("Wells", person.getFirstName());
        assertEquals("Yu", person.getSecondName());
        assertEquals(27, person.getAge());
        assertEquals("Man", person.getGender());
    }

    /**
     * 2. The gender field has following options ‘Woman’, ‘Man’,’Non-binary|gender diverse’, ‘Prefer not to
     * say’ and ‘Other’.
     */
    @Test
    void testValidGender() {
        person.setGender("Man");
        assertEquals("Man", person.getGender());
        person.setGender("Woman");
        assertEquals("Woman", person.getGender());
        person.setGender("Prefer not to say");
        assertEquals("Prefer not to say", person.getGender());
        person.setGender("Other");
        assertEquals("Other", person.getGender());
    }

    /**
     * 2. The gender field has following options ‘Woman’, ‘Man’,’Non-binary|gender diverse’, ‘Prefer not to
     * say’ and ‘Other’.
     */
    @Test
    void testInvalidGender() {
        try {
            person.setGender("X");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.", e.getMessage());
        }
    }

    /**
     * 3. The first name and last name should not start with a number or symbol and can contain only
     * small case and upper-case alphabet letters.
     */
    @Test
    void firstNameValidFormat() {
        person.setFirstName("Wells");
        assertEquals("Wells", person.getFirstName());
    }

    /**
     * 3. The first name and last name should not start with a number or symbol and can contain only
     * small case and upper-case alphabet letters.
     */
    @Test
    void firstNameInvalidFormat() throws IllegalArgumentException {
        try {
            person.setFirstName("1Wells");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }

    /**
     * 3. The first name and last name should not start with a number or symbol and can contain only
     * small case and upper-case alphabet letters.
     */
    @Test
    void secondNameValidFormat() {
        person.setSecondName("Wells");
        assertEquals("Wells", person.getSecondName());
    }

    /**
     * 3. The first name and last name should not start with a number or symbol and can contain only
     * small case and upper-case alphabet letters.
     */
    @Test
    void secondNameInvalidFormat() throws IllegalArgumentException {
        try {
            person.setSecondName("1Wells");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
    }

    @Test
    void testToString() {
        person.setFirstName("Wells");
        person.setSecondName("Yu");
        person.setGender("Man");
        person.setAge(27);
        assertEquals("Passenger{ Fullname= Wells Yu ,email='null', phoneNumber='null', passport='null}", person.toString());
    }
}

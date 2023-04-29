package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest
{
    private Person person;
    @BeforeEach
    void setUp()
    {
        person = new Passenger();
    }

    @Test
    public void testConstructor()
    {
        assertNotNull(person);
    }

    @Test
    public void testAllFields()
    {
        person = new Passenger("Wells","Yu",27, "Man", "cyuu0052@student.monash.com", "0450000000", "123456789", "123456789", 123);
        assertEquals("Wells",person.getFirstName());
        assertEquals("Yu",person.getSecondName());
        assertEquals(27,person.getAge());
        assertEquals("Man",person.getGender());
    }

    @Test
    public void testValidGender()
    {
        person.setGender("Man");
        assertEquals("Man",person.getGender());
    }
    @Test
    public void testInvalidGender()
    {
        try {
            person.setGender("X");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.", e.getMessage());
        }
    }
}

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
        person = new Passenger("Wells","Yu",27, "male", "cyuu0052@student.monash.edu", "0450000000", "123456789", "123456789", 123);
        assertEquals("Wells",person.getFirstName());
        assertEquals("Yu",person.getSecondName());
        assertEquals(29,person.getAge());
        assertEquals("Man",person.getGender());
    }

    private boolean isGenderValid(String gender)
    {
        return gender.equals("Woman") || gender.equals("Man") || gender.equals("Non-binary|gender diverse") || gender.equals("Prefer not to say") || gender.equals("Other");
    }

    @Test
    public void testValidGender()
    {
        person.setGender("Man");
        assertTrue(isGenderValid(person.getGender()));
    }
    @Test
    public void testInvalidGender()
    {
        person.setGender("X");
        assertFalse(isGenderValid(person.getGender()));
    }
}

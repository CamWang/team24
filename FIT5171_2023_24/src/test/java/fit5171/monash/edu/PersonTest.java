package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testConstructor() {
        Person person = new Passenger();
        assertNotNull(person);
    }
}

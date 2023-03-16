import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdderTest {
    private Adder adderObj;
    public AdderTest() {
    }

    @BeforeEach
    void setUp() {
        adderObj = new Adder();
    }

    @Test
    void testEmptyString() {
        int result = adderObj.add("");
        assertEquals(0, result);
    }

    @Test
    void testSingleNumbers() {
        int result = adderObj.add("1");
        assertEquals(1, result);
    }

    @Test
    void testTwoNumbers() {
        int result = adderObj.add("1,2");
        assertEquals(3, result);
    }

    @Test
    void testMoreThanTwoNumbers() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            adderObj.add("1,2,3");
        });
        assertEquals("Up to 2 numbers separated by comma are allowed", exception.getMessage());
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        adderObj.add("1,2");
        assertTrue(true);
    }

    @Test
    public final void whenNonNumbersAIsUsedThenNoExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> {
            adderObj.add("1,X");
        });
    }    
}

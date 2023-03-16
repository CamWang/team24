import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TicketSystemTest {
    private Adder adderObj;
    public AdderTest() {
    }

    @BeforeEach
    void setUp() {
        adderObj = new Adder();
    }
    
    @Test
    public void testBuyTicket() throws Exception {
        BuyTicket buyTicket0 = new BuyTicket();
        int int0 = buyTicket0.buyTicket(0);
        assertEquals(0, int0);
    }
}
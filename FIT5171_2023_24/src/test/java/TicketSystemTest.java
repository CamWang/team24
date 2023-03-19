import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketSystemTest {
    private TicketSystem ticketSystem;
    public TicketSystemTest() {
    }

    @BeforeEach
    void setUp() {
        ticketSystem = new TicketSystem();
    }

    @Test
    void testInvalidTicketId() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.buyTicket(0);
        });
        assertEquals("This ticket does not exist.", exception.getMessage());
    }
}
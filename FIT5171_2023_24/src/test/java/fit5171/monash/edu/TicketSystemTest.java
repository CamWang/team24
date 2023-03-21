package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fit5171.monash.edu.Passenger;
import fit5171.monash.edu.Ticket;
import fit5171.monash.edu.TicketSystem;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TicketSystemTest {
    private TicketSystem ticketSystem;
    private Ticket ticket;
    private ArrayList<Ticket> tickets;
    private Passenger passenger;

    public TicketSystemTest() {

    }

    @BeforeAll
    static void initAll() {

    }

    @BeforeEach
    public void setUp() {
        ticketSystem = new TicketSystem();
    }

    /**
     * Tests the calculateTotalCost method with a valid input.
     * Sets up an Order object with three items and calculates the total cost.
     * The expected output is the sum of the prices of the three items.
     */
    @Test
    void testInvalidTicketId() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            ticketSystem.buyTicket(0);
        });
        assertEquals("This ticket does not exist.", exception.getMessage());
    }

    @Test
    public void testTicketPriceForSeniorOrJunior() {
        // Test for Whether Senior of Junior price is correct displayed
        tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 330, "CA979", true, "John"));
        tickets.add(new Ticket(1, 0, "CA979", True, "John"));
        int juniorPrice = 330;
        int seniorPrice = 0;
        assertEquals(juniorPrice, ticket.getPrice());
        assertEquals(seniorPrice, ticket.getPrice());
    }

    @Test
    public void testMultipleTicketPriceDisplayed() {
        // Test for whether the price of multiple displayed correctly.
        tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 330, "CA979", True, "John"));
        int numTickets = 2;
        int multipleTicketPrice = 660;
        assertEquals(660, ticket.getPrice() * numTickets);
    }

    @Test
    public void testTicketStatusUpdated() {
        tickets.add(new Ticket(1, 330, "CA979", True, "John"));
        assertFalse(ticket.ticketStatus());
    }

    @Test
    public void testMaxNoOfTicketPurchase() {
        int maxAvailableNoOfTicket = 675;
        int maxNoOfTicketPurchased = 676;
        // Need new method for available ticket
        assertEquals(maxAvailableNoOfTicket, maxNoOfTicketPurchased);

    }

}
/*
 * int ticket_id,int price, Flight flight, boolean classVip, Passenger passenger
 */
package fit5171.monash.edu;

import fit5171.monash.edu.collection.TicketCollection;
import fit5171.monash.edu.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class TicketCollectionTest {
    @Mock
    private ArrayList<Ticket> mockTickets;
    @Mock
    private Ticket mockTicket;

    @BeforeEach
    public void setUp() {
        mockTickets = new ArrayList<Ticket>();
        mockTicket = mock(Ticket.class);
        mockTickets.add(mockTicket);

        TicketCollection.tickets = mockTickets;
    }

    /**
     * 1. Whenever a ticket is being added to the TicketCollection, it must be validated.
     */
    @Test
    public void testAddTicketValid() {
        when(mockTicket.getTicket_id()).thenReturn(1);

        TicketCollection.addTickets(new ArrayList<Ticket>() {{
            add(mockTicket);
        }});

        assertEquals(mockTickets.size(), 2);
    }

    /**
     * 1. Whenever a ticket is being added to the TicketCollection, it must be validated.
     */
    @Test
    public void testAddTicketInvalid() throws IllegalArgumentException {
        when(mockTicket.getTicket_id()).thenReturn(0);

        try {
            TicketCollection.addTickets(new ArrayList<Ticket>() {{
                add(mockTicket);
            }});
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid ticket ID: 0", e.getMessage());
        }
    }

    /**
     * 2. When trying to get a ticket, the correct ticket is returned.
     */
    @Test
    public void testGetTicketInfoValid() {
        int ticketId = 2;
        when(mockTicket.getTicket_id()).thenReturn(ticketId);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertEquals(mockTicket, result);
    }

    /**
     * 2. When trying to get a ticket, the correct ticket is returned.
     */
    @Test
    public void testGetTicketInfoInvalid() {
        int ticketId = 3;
        when(mockTicket.getTicket_id()).thenReturn(4);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertNull(result);
    }
}

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
    void setUp() {
        mockTickets = new ArrayList<>();
        mockTicket = mock(Ticket.class);
        mockTickets.add(mockTicket);

        TicketCollection.tickets = mockTickets;
    }

    /**
     * 1. Whenever a ticket is being added to the TicketCollection, it must be validated.
     */
    @Test
    void testAddTicketValid() {
        when(mockTicket.getTicketId()).thenReturn(1);

        TicketCollection.addTickets(new ArrayList<Ticket>() {{
            add(mockTicket);
        }});

        assertEquals(2, mockTickets.size());
    }

    /**
     * 1. Whenever a ticket is being added to the TicketCollection, it must be validated.
     */
    @Test
    void testAddTicketInvalid() throws IllegalArgumentException {
        when(mockTicket.getTicketId()).thenReturn(0);
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(mockTicket);
        try {
            TicketCollection.addTickets(tickets);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid ticket ID: 0", e.getMessage());
        }
    }

    /**
     * 2. When trying to get a ticket, the correct ticket is returned.
     */
    @Test
    void testGetTicketInfoValid() {
        int ticketId = 2;
        when(mockTicket.getTicketId()).thenReturn(ticketId);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertEquals(mockTicket, result);
    }

    /**
     * 2. When trying to get a ticket, the correct ticket is returned.
     */
    @Test
    void testGetTicketInfoInvalid() {
        int ticketId = 3;
        when(mockTicket.getTicketId()).thenReturn(4);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertNull(result);
    }
}

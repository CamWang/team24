package fit5171.monash.edu;

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
//        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
//        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
//                "08/06/23 15:00:00", airplane);
        mockTickets = new ArrayList<Ticket>();
        mockTicket = mock(Ticket.class);
        mockTickets.add(mockTicket);

        TicketCollection.tickets = mockTickets;
    }

    @Test
    public void testAddTicketValid() {
        when(mockTicket.getTicket_id()).thenReturn(1);

        TicketCollection.addTickets(new ArrayList<Ticket>() {{ add(mockTicket); }});

        assertEquals(mockTickets.size(), 2);
    }

    @Test
    public void testAddTicketInvalid() throws IllegalArgumentException {
        when(mockTicket.getTicket_id()).thenReturn(0);

        try {
            TicketCollection.addTickets(new ArrayList<Ticket>() {{ add(mockTicket); }});
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid ticket ID: 0", e.getMessage());
        }
    }

    @Test
    public void testGetTicketInfoValid() {
        int ticketId = 2;
        when(mockTicket.getTicket_id()).thenReturn(ticketId);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertEquals(mockTicket, result);
    }

    @Test
    public void testGetTicketInfoInvalid() {
        int ticketId = 3;
        when(mockTicket.getTicket_id()).thenReturn(4);

        Ticket result = TicketCollection.getTicketInfo(ticketId);

        assertNull(result);
    }
}

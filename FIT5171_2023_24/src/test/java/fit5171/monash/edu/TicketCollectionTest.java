package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;

public class TicketCollectionTest {

    private ArrayList<Ticket> mockTickets;
    private Ticket mockTicket;

    @BeforeEach
    public void setUp() throws ParseException {
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
    public void testAddTicketInvalid() {
        when(mockTicket.getTicket_id()).thenReturn(0);

        try {
            TicketCollection.addTickets(new ArrayList<Ticket>() {{ add(mockTicket); }});
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
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

//    @Test
//    public void testGetTickets() {
//        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
//                "123456789", "123456789", 123);
//        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);
//        assertEquals(TicketCollection.tickets, TicketCollection.getTickets());
//    }
//
//    @Test
//    public void testAddTickets() {
//        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
//                "123456789", "123456789", 123);
//        Ticket ticket1 = new Ticket(1, 1000, flight, true, passenger);
//        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);
//
//        TicketCollection.tickets = new ArrayList<Ticket>();
//        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2));
//        TicketCollection.addTickets(tickets_db);
//        assertEquals(tickets_db, TicketCollection.tickets);
//    }
//
//    @Test
//    public void testGetAllTickets() {
//        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
//                "123456789", "123456789", 123);
//        Ticket ticket1 = new Ticket(1, 1000, flight, true, passenger);
//
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(output));
//        TicketCollection.tickets = new ArrayList<Ticket>();
//        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1));
//        TicketCollection.addTickets(tickets_db);
//        TicketCollection.getAllTickets();
//        String expectedString = "Ticket{" + '\n' +
//                "Price=1120KZT, " + '\n' +
//                "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}" + '\n' +
//                "Vip status=true" + '\n' +
//                "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450 000 000', passport='123456789}" + '\n' +
//                "Ticket was purchased=false" + "\n}" + System.lineSeparator();
//        assertEquals(expectedString, output.toString());
//    }
//
//    @Test
//    public void testGetTicketInfoWithInvalidTicket_id() {
//        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
//                "123456789", "123456789", 123);
//        Ticket ticket1 = new Ticket(1, 1000, flight, true, passenger);
//        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);
//
//        TicketCollection.tickets = new ArrayList<Ticket>();
//        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2));
//        TicketCollection.addTickets(tickets_db);
//        assertEquals(null, TicketCollection.getTicketInfo(0));
//    }
//
//    @Test
//    public void testGetTicketInfoWithValidTicket_id() {
//        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
//                "123456789", "123456789", 123);
//        Ticket ticket1 = new Ticket(1, 1000, flight, true, passenger);
//        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);
//
//        TicketCollection.tickets = new ArrayList<Ticket>();
//        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2));
//        TicketCollection.addTickets(tickets_db);
//        assertEquals(ticket1, TicketCollection.getTicketInfo(1));
//    }
}

package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;


public class TicketSystemTest {
    private TicketSystem ticketSystem;
    private Airplane airplane1;
    private Flight flight1;
    private Flight flight2;
    private Passenger passenger1;
    private Passenger passenger2;
    private Ticket ticket1;
    private Ticket ticket2;
    private Ticket ticket3;

    @BeforeEach
    public void setUp() {
        ticketSystem = new TicketSystem();
        airplane1 = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight1 = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane1);
        flight2 = new Flight(2, "Melbourne", "Taipei", "EA001", "Evaair", Timestamp.valueOf("2023-6-9 12:00:00"),
                Timestamp.valueOf("2023-6-9 15:00:00"), airplane1);
        passenger1 = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
                "123456789", "123456789", 123);
        passenger2 = new Passenger("MingZe", "Li", 82, "female", "mlii0181@student.monash.edu", "0450 000 001",
                "987654321", "987654321", 124);
        ticket1 = new Ticket(1, 1000, flight1, true, passenger1);
        ticket2 = new Ticket(2, 1000, flight1, true, passenger2);
        ticket3 = new Ticket(3, 1000, flight1, true, passenger2);
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2));
        TicketCollection.addTickets(tickets_db);
    }

    @Test
    public void testMyMethod() throws Exception {
        String testInput = "25\n";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);
        TicketSystem myClass = new TicketSystem();
        int result = myClass.test();
        assertEquals(25, result);
    }

    @Test
    void testValidTicketId() throws Exception {
        String input = "Wells\nYu\n27\nmale\ncyuu0052@student.monash.edu\n" +
                "0450000000\n123456789\n1\n123456789\n123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ticketSystem.buyTicket(3);
        assertEquals("Wells", ticket3.getPassenger().getFirstName());
        assertEquals("Yu", ticket3.getPassenger().getSecondName());
        assertEquals(27, ticket3.getPassenger().getAge());

    }

    @Test
    public void testMultipleTicketPriceDisplayed() {
        // Test for whether the price of multiple displayed correctly.
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
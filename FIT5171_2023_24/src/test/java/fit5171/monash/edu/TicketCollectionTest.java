package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;

public class TicketCollectionTest {
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
    }

    @Test
    public void testGetTickets() {
        assertEquals(TicketCollection.tickets, TicketCollection.getTickets());
    }

    @Test
    public void testAddTickets() {
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2, ticket3));
        TicketCollection.addTickets(tickets_db);
        assertEquals(tickets_db, TicketCollection.tickets);
    }
    @Test
    public void testGetAllTickets() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1));
        TicketCollection.addTickets(tickets_db);
        TicketCollection.getAllTickets();
        String expectedString = "Ticket{" + '\n' +
            "Price=1120KZT, " + '\n' +
            "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', code=QF001', company=Qantas', code=QF001'}" + '\n' + 
            "Vip status=true" + '\n' +
            "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450 000 000', passport='123456789}" + '\n' + 
            "Ticket was purchased=false" + "\n}" + System.lineSeparator();
        assertEquals(expectedString, output.toString());
    }

    @Test
    public void testGetTicketInfoWithInvalidTicket_id() {
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2, ticket3));
        TicketCollection.addTickets(tickets_db);
        assertEquals(null, TicketCollection.getTicketInfo(0));
    }

    @Test
    public void testGetTicketInfoWithValidTicket_id() {
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2, ticket3));
        TicketCollection.addTickets(tickets_db);
        assertEquals(ticket1, TicketCollection.getTicketInfo(1));
    }
}

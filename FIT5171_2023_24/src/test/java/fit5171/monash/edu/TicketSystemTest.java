package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.io.PrintStream;
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
    void testBuyTicketWithValidInput() throws Exception {
        String testInput = "Cheng-Han\nYu\n27\nmale\ncyuu0052@student.monash.edu\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket1, ticket2, ticket3));
        TicketCollection.addTickets(tickets_db);

        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight1, flight2));
        FlightCollection.addFlights(flights_db);

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(3);

        assertEquals("Cheng-Han", ticket3.getPassenger().getFirstName());
        assertEquals("Yu", ticket3.getPassenger().getSecondName());
        assertEquals(27, ticket3.getPassenger().getAge());
        assertEquals("male", ticket3.getPassenger().getGender());
        assertEquals("cyuu0052@student.monash.edu", ticket3.getPassenger().getEmail());
        assertEquals("0450000000", ticket3.getPassenger().getPhoneNumber());
        assertEquals("987654321", ticket3.getPassenger().getPassport());
        assertEquals("987654321", ticket3.getPassenger().getCardNumber());
        assertEquals(987, ticket3.getPassenger().getSecurityCode());
    }

    // @Test
    // public void testMultipleTicketPriceDisplayed() {
    // // Test for whether the price of multiple displayed correctly.
    // int numTickets = 2;
    // int multipleTicketPrice = 660;
    // assertEquals(660, ticket.getPrice() * numTickets);
    // }

    // @Test
    // public void testMaxNoOfTicketPurchase() {
    // int maxAvailableNoOfTicket = 675;
    // int maxNoOfTicketPurchased = 676;
    // // Need new method for available ticket
    // assertEquals(maxAvailableNoOfTicket, maxNoOfTicketPurchased);
    // }

    @Test
    void testShowTicket() {
        // Create timestamp objects
        Timestamp dateFrom = new Timestamp(123, 0, 0, 0, 0, 0, 0);
        Timestamp dateTo = new Timestamp(123, 0, 1, 0, 0, 0, 0);

        // Create Airplane, Flight, Passenger, Ticket objects
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 100, 10);
        Flight flight = new Flight(1, "Melbourne", "Sydney", "SM001", "MonashAir", dateFrom, dateTo, airplane);
        Passenger passenger = new Passenger("Ping", "He", 22, "Female", "phee0011@student.monash.edu", "0421111111",
                "CN001", "46221111", 111);
        Ticket ticket = new Ticket(1, 200, flight, false, passenger);

        // Add the ticket to the TicketCollection
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket));
        TicketCollection.addTickets(tickets_db);

        // Redirect console output to a ByteArrayOutputStream for testing
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Call the showTicket() method on the Ticket object
        TicketSystem ticketSystem = new TicketSystem();
        // Pass the objects to the TicketSystem object
        ticketSystem.passenger = passenger;
        ticketSystem.ticket = ticket;
        ticketSystem.flight = flight;
        ticketSystem.showTicket();

        // Check if the console output matches the expected output
        // line separator is different from "\n" in comparison, although they look the
        // same in output
        String expectedOutput = "You have bought a ticket for flight Sydney - Melbourne\n\nDetails:"
                + System.lineSeparator() + ticket.toString() + System.lineSeparator();
        assertEquals(expectedOutput, output.toString());
    }

}
/*
 * int ticket_id,int price, Flight flight, boolean classVip, Passenger passenger
 */
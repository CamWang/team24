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

    @BeforeEach
    public void setUp() {
    }

    @Test
    void testBuyTicketWithValidInput() throws Exception {
        String testInput = "Cheng-Han\nYu\n27\nmale\ncyuu0052@student.monash.edu\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", Timestamp.valueOf("2023-6-8 12:00:00"),
                Timestamp.valueOf("2023-6-8 15:00:00"), airplane);
        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450 000 000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);

        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket));
        TicketCollection.addTickets(tickets_db);

        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(1);

        assertEquals("Cheng-Han", ticket.getPassenger().getFirstName());
        assertEquals("Yu", ticket.getPassenger().getSecondName());
        assertEquals(27, ticket.getPassenger().getAge());
        assertEquals("male", ticket.getPassenger().getGender());
        assertEquals("cyuu0052@student.monash.edu", ticket.getPassenger().getEmail());
        assertEquals("0450000000", ticket.getPassenger().getPhoneNumber());
        assertEquals("987654321", ticket.getPassenger().getPassport());
        assertEquals("987654321", ticket.getPassenger().getCardNumber());
        assertEquals(987, ticket.getPassenger().getSecurityCode());
    }

    @Test
    void testShowTicket() {
        Timestamp dateFrom = new Timestamp(123, 0, 0, 0, 0, 0, 0);
        Timestamp dateTo = new Timestamp(123, 0, 1, 0, 0, 0, 0);

        Airplane airplane = new Airplane(1, "Boeing 747", 10, 100, 10);
        Flight flight = new Flight(1, "Melbourne", "Sydney", "SM001", "MonashAir", dateFrom, dateTo, airplane);
        Passenger passenger = new Passenger("Ping", "He", 22, "Female", "phee0011@student.monash.edu", "0421111111",
                "CN001", "46221111", 111);
        Ticket ticket = new Ticket(1, 200, flight, false, passenger);

        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket));
        TicketCollection.addTickets(tickets_db);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.passenger = passenger;
        ticketSystem.ticket = ticket;
        ticketSystem.flight = flight;
        ticketSystem.showTicket();

        String expectedOutput = "You have bought a ticket for flight Sydney - Melbourne\n\nDetails:"
                + System.lineSeparator() + ticket.toString() + System.lineSeparator();
        assertEquals(expectedOutput, output.toString());
    }

}
/*
 * int ticket_id,int price, Flight flight, boolean classVip, Passenger passenger
 */
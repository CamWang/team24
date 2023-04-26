package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Timestamp;

public class TicketSystemTest {
    private TicketSystem ticketSystem;
    private FlightCollection flightCollection;
    private TicketCollection ticketCollection;
    private Ticket ticket;
    private Airplane airplane;
    private Flight flight;
    @BeforeEach
    public void setUp() throws ParseException {
        flightCollection = mock(FlightCollection.class);
        ticketCollection = mock(TicketCollection.class);
        ticketSystem = new TicketSystem();
        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
    }

    @Test
    public void testBuyTicketWithValidInput() throws Exception {
        String testInput = "Cheng-Han\nYu\n27\nMan\ncyuu0052@student.monash.edu\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        Passenger passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);

        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket));
        TicketCollection.addTickets(tickets_db);

        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(1);

        assertEquals("ChengHan", ticket.getPassenger().getFirstName());
        assertEquals("Yu", ticket.getPassenger().getSecondName());
        assertEquals(27, ticket.getPassenger().getAge());
        assertEquals("Man", ticket.getPassenger().getGender());
        assertEquals("cyuu0052@student.monash.edu", ticket.getPassenger().getEmail());
        assertEquals("0450000000", ticket.getPassenger().getPhoneNumber());
        assertEquals("987654321", ticket.getPassenger().getPassport());
        assertEquals("987654321", ticket.getPassenger().getCardNumber());
        assertEquals(987, ticket.getPassenger().getSecurityCode());
    }

    @Test
    public void testShowTicket() {
        Timestamp dateFrom = new Timestamp(123, 0, 0, 0, 0, 0, 0);
        Timestamp dateTo = new Timestamp(123, 0, 1, 0, 0, 0, 0);

        Passenger passenger = new Passenger("Ping", "He", 22, "Woman", "phee0011@student.monash.edu", "0421111111",
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

    /*
          When choosing a ticket, a valid city is used.
     */
    @Test
    public void testTicketWithValidCity() {
        String testCity1 = "Sydney";
        String testCity2 = "Melbourne";
        Flight flight = mock(Flight.class);
        when(flightCollection.getFlightInfo(testCity1, testCity2)).thenReturn(flight);
        Flight result = flightCollection.getFlightInfo(testCity1, testCity2);
        assertEquals(flight, result);

    }

    @Test
    public void testTicketWithInvalidCity() {
        String testCity1 = "Invalid1";
        String testCity2 = "Invalid2";
        Flight flight = mock(Flight.class);
        when(flightCollection.getFlightInfo(testCity1, testCity2)).thenReturn(null);
        Flight result = flightCollection.getFlightInfo(testCity1, testCity2);
        assertNull(result);
    }

    /*
        If a passenger chooses an already booked ticket it should display an error message.
    */
    @Test
    public void testBookedTicketthrowerrormessage()
    {
        Ticket ticket = mock(Ticket.class);
        when(ticket.ticketStatus()).thenReturn(Boolean.valueOf(true));
        when(ticketSystem.getTicketCollection().getTicketInfo(1)).thenReturn(ticket); // Use the existing TicketSystem instance
        assertDoesNotThrow(() -> ticketSystem.buyTicket(1, 2));
    }

}



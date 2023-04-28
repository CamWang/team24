package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

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
    private FlightCollection mockFlightCollection;
    private TicketCollection mockTicketCollection;
    private Ticket ticket;
    private Ticket mockTicket;
    private Airplane airplane;
    private Airplane mockAirplane;
    private Flight flight;
    private Flight mockFlight;
    private Passenger passenger;
    private Passenger mockPassenger;

    @BeforeEach
    public void setUp() throws ParseException {
        mockFlightCollection = mock(FlightCollection.class);
        mockTicketCollection = mock(TicketCollection.class);
        mockTicket = mock(Ticket.class);
        mockPassenger = mock(Passenger.class);
        mockAirplane = mock(Airplane.class);
        mockFlight = mock(Flight.class);

        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.com", "0450000000",
                "123456789", "123456789", 123);
        ticket = new Ticket(1, 1000, flight, false, passenger);
        TicketCollection.tickets = new ArrayList<Ticket>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket));
        TicketCollection.addTickets(tickets_db);
        FlightCollection.flights = new ArrayList<Flight>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight));
        FlightCollection.addFlights(flights_db);
    }

    /**
     * 1. When choosing a ticket, a valid city is used.
     */
    @Test
    public void testTicketWithValidCity() throws Exception {
        String testCity1 = "Melbourne";
        String testCity2 = "Sydney";
        String testInput = "1\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket("Melbourne", "Sydney");

        String expectedOutput = "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.com', phoneNumber='0450000000', passport='123456789}\n" +
                "Ticket was purchased=false";
        assert output.toString().contains(expectedOutput);
    }

    @Test
    public void testBuyTicketWithValidInput() throws Exception {
        String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987";

        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(1);

        assertEquals("ChengHan", ticket.getPassenger().getFirstName());
        assertEquals("Yu", ticket.getPassenger().getSecondName());
        assertEquals(27, ticket.getPassenger().getAge());
        assertEquals("Man", ticket.getPassenger().getGender());
        assertEquals("cyuu0052@student.monash.com", ticket.getPassenger().getEmail());
        assertEquals("0450000000", ticket.getPassenger().getPhoneNumber());
        assertEquals("987654321", ticket.getPassenger().getPassport());
        assertEquals("987654321", ticket.getPassenger().getCardNumber());
        assertEquals(987, ticket.getPassenger().getSecurityCode());
    }

    @Test
    public void testShowTicket() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.passenger = passenger;
        ticketSystem.ticket = ticket;
        ticketSystem.flight = flight;
        ticketSystem.showTicket();

        String expectedOutput = "You have bought a ticket for flight Melbourne - Sydney\n\nDetails:"
                + System.lineSeparator() + ticket.toString() + System.lineSeparator();
        assertEquals(expectedOutput, output.toString());
    }


//
//    @Test
//    public void testTicketWithInvalidCity() {
//        String testCity1 = "Invalid1";
//        String testCity2 = "Invalid2";
//        Flight flight = mock(Flight.class);
//        when(flightCollection.getFlightInfo(testCity1, testCity2)).thenReturn(null);
//        Flight result = flightCollection.getFlightInfo(testCity1, testCity2);
//        assertNull(result);
//    }
//
//    /*
//        If a passenger chooses an already booked ticket it should display an error message.
//    */
//    @Test
//    public void testBookedTicketthrowerrormessage()
//    {
//        Ticket ticket = mock(Ticket.class);
//        when(ticket.ticketStatus()).thenReturn(Boolean.valueOf(true));
//        when(ticketSystem.getTicketCollection().getTicketInfo(1)).thenReturn(ticket); // Use the existing TicketSystem instance
//        assertDoesNotThrow(() -> ticketSystem.buyTicket(1, 2));
//    }

}



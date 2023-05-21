package fit5171.monash.edu;

import fit5171.monash.edu.collection.FlightCollection;
import fit5171.monash.edu.collection.TicketCollection;
import fit5171.monash.edu.entity.Airplane;
import fit5171.monash.edu.entity.Flight;
import fit5171.monash.edu.entity.Passenger;
import fit5171.monash.edu.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class TicketSystemTest {
    private Ticket ticket;
    private Ticket ticket2;
    private Airplane airplane;
    private Flight flight;
    private Flight flight2;
    private Passenger passenger;

    @BeforeEach
    public void setUp() throws ParseException {
        airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        flight2 = new Flight(2, "Brisbane", "Sydney", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
//        passenger = new Passenger("Wells", "Yu", 27, "Man", "cyuu0052@student.monash.com", "0450000000",
//                "123456789", "123456789", 123);
        passenger = new Passenger("null", "null", 1, "Other");
        ticket = new Ticket(1, 1000, flight, false, passenger);
        ticket2 = new Ticket(2, 1000, flight2, false, passenger);
        TicketCollection.tickets = new ArrayList<>();
        ArrayList<Ticket> tickets_db = new ArrayList<>(Arrays.asList(ticket, ticket2));
        TicketCollection.addTickets(tickets_db);
        FlightCollection.flights = new ArrayList<>();
        ArrayList<Flight> flights_db = new ArrayList<>(Arrays.asList(flight, flight2));
        FlightCollection.addFlights(flights_db);
    }

    @Test
    public void testValidSystem() throws Exception {
        TicketCollection.tickets.clear();
        FlightCollection.flights.clear();
        String testInput = "Melbourne\nSydney\n1\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987\n0\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Main.main(new String[0]);
        assertEquals(("Welcome to the Arline Ticket Booking System!\n" +
                "Please, enter the departure city:\n" +
                "Please, enter the destination city:\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=17/07/23 13:13:13, ', date from='16/07/23 12:12:12', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF485'}\n" +
                "Vip status=false\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=17/07/23 13:13:13, ', date from='16/07/23 12:12:12', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF485'}\n" +
                "Vip status=true\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=Bowening787-MAX', business sits=30', economy sits=300', crew sits=10'}, date to=03/08/23 15:15:15, ', date from='02/08/23 14:14:14', depart from='Perth', depart to='ShangHai', company=Qantas', code=QF075'}\n" +
                "Vip status=false\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=13/06/23 19:19:19, ', date from='11/06/23 18:18:18', depart from='LosAngles', depart to='Paris', company=Qantas', code=QF255'}\n" +
                "Vip status=true\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=02/11/23 17:17:17, ', date from='01/11/23 16:16:16', depart from='Melbourne', depart to='LosAngles', company=Qantas', code=QF064'}\n" +
                "Vip status=false\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=02/11/23 17:17:17, ', date from='01/11/23 16:16:16', depart from='Melbourne', depart to='LosAngles', company=Qantas', code=QF064'}\n" +
                "Vip status=true\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=13/06/23 19:19:19, ', date from='11/06/23 18:18:18', depart from='LosAngles', depart to='Paris', company=Qantas', code=QF255'}\n" +
                "Vip status=true\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=300', crew sits=8'}, date to=17/07/23 13:13:13, ', date from='16/07/23 12:12:12', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF485'}\n" +
                "Vip status=false\n" +
                "null\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "\n" +
                "Enter ID of ticket you want to choose:\n" +
                "Please, enter your first name:\n" +
                "Please, enter your second name:\n" +
                "Please, enter your age:\n" +
                "Please, enter your gender:\n" +
                "Please, enter your email address:\n" +
                "Please, enter your phone number:\n" +
                "Please, enter your passport number:\n" +
                "Do you want to purchase?\n" +
                " 1-YES 0-NO\n" +
                "Your bill: 0\n" +
                "\n" +
                "Enter your card number:\n" +
                "Enter your security code:\n" +
                "You have bought a ticket for flight Melbourne - Sydney\n" +
                "\n" +
                "Details:\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=50', economy sits=299', crew sits=8'}, date to=17/07/23 13:13:13, ', date from='16/07/23 12:12:12', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF485'}\n" +
                "Vip status=false\n" +
                "Passenger{ Fullname= ChengHan Yu ,email='cyuu0052@student.monash.com', phoneNumber='0450000000', passport='987654321}\n" +
                "Ticket was purchased=true\n" +
                "}\n" +
                "Do you want to buy another tickets?\n" +
                " 1-YES 0-NO\n" +
                "Thank you for using our system!\n").replace("\n", "").replace("\r", "").trim(), output.toString().replace("\r", "").replace("\n", "").trim());
    }

    @Test
    public void testInterchangeSystem() throws Exception {
        TicketCollection.tickets.clear();
        FlightCollection.flights.clear();
        String testInput = "Melbourne\nParis\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987\n0\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Main.main(new String[0]);
        assertEquals(("Welcome to the Arline Ticket Booking System!\n" +
                "Please, enter the departure city:\n" +
                "Please, enter the destination city:\n" +
                "There is special way to go there. And it is transfer way, like above. Way №1\n" +
                "4 3\n" +
                "Processing...\n" +
                "Please, enter your first name:\n" +
                "Please, enter your second name:\n" +
                "Please, enter your age:\n" +
                "Please, enter your gender:\n" +
                "Please, enter your email address:\n" +
                "Please, enter your phone number:\n" +
                "Please, enter your passport number:\n" +
                "Do you want to purchase?\n" +
                " 1-YES 0-NO\n" +
                "--*-*--\n" +
                "--*-*--\n" +
                "Your bill: 0\n" +
                "\n" +
                "Enter your card number:\n" +
                "Enter your security code:\n" +
                "You have bought a ticket for flight LosAngles - Paris\n" +
                "\n" +
                "Details:\n" +
                "Ticket{\n" +
                "Price=0KZT, \n" +
                "Flight{Airplane{model=A380', business sits=49', economy sits=299', crew sits=8'}, date to=13/06/23 19:19:19, ', date from='11/06/23 18:18:18', depart from='LosAngles', depart to='Paris', company=Qantas', code=QF255'}\n" +
                "Vip status=false\n" +
                "Passenger{ Fullname= ChengHan Yu ,email='cyuu0052@student.monash.com', phoneNumber='0450000000', passport='987654321}\n" +
                "Ticket was purchased=false\n" +
                "}\n" +
                "Do you want to buy another tickets?\n" +
                " 1-YES 0-NO\n" +
                "Thank you for using our system!").replace("\n", ""), output.toString().replace("\r", "").replace("\n", ""));
    }

    /**
     * 1. When choosing a ticket, a valid city is used.
     */
    @Test
    public void chooseTicketWithValidCity() throws Exception {
        String testInput = "1\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket("Melbourne", "Sydney");

        String expectedOutput = "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=08/06/23 15:00:00, ', date from='08/06/23 12:00:00', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}";
        assertTrue(output.toString().contains(expectedOutput));
    }

    /**
     * 1. When choosing a ticket, a valid city is used.
     */
    @Test
    public void chooseTicketWithTransferWay() throws Exception {

        String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket("Melbourne", "Brisbane");

        String expectedOutput = "There is special way to go there. And it is transfer way, like above.";
        assertTrue(output.toString().contains(expectedOutput));
    }

    /**
     * 1. When choosing a ticket, a valid city is used.
     */
    @Test
    public void chooseTicketWithInvalidCity() throws Exception {
        String testInput = "1\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.chooseTicket("Melbourne123", "Sydney");
        String expectedOutput = "There is no possible variants.";
        assertTrue(output.toString().contains(expectedOutput));
    }

    /**
     * 2. If a passenger chooses an already booked ticket it should display an error message.
     */
    @Test
    public void testBookedTicket() {
        String testInput = "1\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        TicketCollection.getTicketInfo(1).setTicketStatus(true);
        TicketSystem ticketSystem = new TicketSystem();
        try {
            ticketSystem.chooseTicket("Melbourne", "Sydney");
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("This ticket is already booked.", e.getMessage());
        }
    }

    /**
     * 3. Appropriate checks have been implemented to validate passenger information
     */
    @Test
    public void testBuyTicketWithInvalidPassenger() {
        try {
            String testInput = "ChengHan123\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu123\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Name can contain only small case and upper-case alphabet letters.", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu\ntwenty\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Age must be an integer.", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu\n27\nmale\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Wrong email format", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student.com\n04123456789";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Wrong phone number format", e.getMessage());
        }
        try {
            String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student.com\n0412345678\n1234567890\n";
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            TicketSystem ticketSystem = new TicketSystem();
            ticketSystem.buyTicket(1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Wrong passport number format", e.getMessage());
        }
    }

    /**
     * 6. A correct value is displayed to the passenger when buying a ticket.
     */
    @Test
    public void testBuyTicketWithValidInput() {
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
    public void testBuyTicketButDontBuy() {
        String testInput = "ChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n0";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        TicketSystem ticketSystem = new TicketSystem();
        assertDoesNotThrow(() -> ticketSystem.buyTicket(1));
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

    @Test
    public void testBuyTicketNotValidId() {
        TicketSystem ticketSystem = new TicketSystem();
        assertThrows(RuntimeException.class, () -> ticketSystem.buyTicket(100));
    }

    @Test
    public void testBuyTicketNotValidBothIds() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(100, 200);
        String expectedOutput = "At least one ticket does not exist.";
        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    public void testBuyTicketNotValidFirstId() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(100, 1);
        String expectedOutput = "At least one ticket does not exist.";
        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    public void testBuyTicketNotValidSecondId() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.buyTicket(1, 200);
        String expectedOutput = "At least one ticket does not exist.";
        assertTrue(output.toString().contains(expectedOutput));
    }

    @Test
    public void testEnterInvalidTicketId() {
        String testInput = "100\n";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        assertThrows(Exception.class, () -> new TicketSystem().chooseTicket("Melbourne", "Sydney"));

    }

    @Test
    public void testSetTicketInformation(){
        ticket.setPassenger(passenger);
        ticket.setTicketId(1);
        ticket.setFlight(flight);
        ticket.setPrice(100);
        ticket.setClassVip(true);
        ticket.setTicketStatus(true);
        assertEquals(ticket.getPassenger(),passenger);
        assertEquals(1,ticket.getTicketId());
        assertEquals(flight,ticket.getFlight());
        assertEquals(50,ticket.getPrice());
        assertTrue(ticket.getClassVip());
        assertTrue(ticket.getTicketStatus());
    }
}



package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.text.ParseException;

public class TicketTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testConstructor() {
        Ticket ticket = new Ticket();
        assertNotNull(ticket);
    }

    @Test
    public void testSetterMethods() throws ParseException {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        Passenger passenger = new Passenger("Wells", "Yu", 27, "male", "cyuu0052@student.monash.edu", "0450000000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);

        ticket.setTicket_id(3);
        ticket.setPrice(2000);
        ticket.setFlight(flight);
        ticket.setClassVip(false);
        ticket.setTicketStatus(true);
        ticket.setPassenger(passenger);

        assertEquals(3, ticket.getTicket_id());
        assertEquals(2240, ticket.getPrice());
        assertEquals(flight, ticket.getFlight());
        assertFalse(ticket.getClassVip());
        assertTrue(ticket.ticketStatus());
        assertEquals(passenger, ticket.getPassenger());
    }

    @Test
    public void testSaleByAgeWithJunior() throws ParseException {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        Passenger passenger = new Passenger("Wells", "Yu", 3, "male", "cyuu0052@student.monash.edu", "0450 000 000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);

        assertEquals(560, ticket.getPrice());
    }

    @Test
    public void testSaleByAgeWithSenior() throws ParseException {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        Passenger passenger = new Passenger("Wells", "Yu", 82, "male", "cyuu0052@student.monash.edu", "0450 000 000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);

        ticket.saleByAge(passenger.getAge());
        assertEquals(0, ticket.getPrice());
    }

    @Test
    public void testToStringMethod() throws ParseException {
        Airplane airplane = new Airplane(1, "Boeing 747", 10, 200, 5);
        Flight flight = new Flight(1, "Sydney", "Melbourne", "QF001", "Qantas", "08/06/23 12:00:00",
                "08/06/23 15:00:00", airplane);
        Passenger passenger = new Passenger("Wells", "Yu", 28, "male", "cyuu0052@student.monash.edu", "0450 000 000",
                "123456789", "123456789", 123);
        Ticket ticket = new Ticket(1, 1000, flight, true, passenger);

        String expectedString = "Ticket{" + '\n' +
                "Price=1120KZT, " + '\n' +
                "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', company=Qantas', code=QF001'}" + '\n' +
                "Vip status=true" + '\n' +
                "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450 000 000', passport='123456789}" + '\n' +
                "Ticket was purchased=false" + "\n}";
        assertEquals(expectedString, ticket.toString());
    }

}

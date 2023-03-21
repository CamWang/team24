package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

public class TicketTest {
    private Airplane airplane1;
    private Flight flight1;
    private Flight flight2;
    private Passenger passenger1;
    private Passenger passenger2;
    private Ticket ticket1;
    private Ticket ticket2;

    @BeforeEach
    void setUp() {
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
        ticket2 = new Ticket(2, 1000, flight1, true, passenger1);
    }

    @Test
    public void TestGetterMethods() {
        assertEquals(1, ticket1.getTicket_id());
        assertEquals(1120, ticket1.getPrice());
        assertEquals(flight1, ticket1.getFlight());
        assertEquals(true, ticket1.getClassVip());
        assertEquals(false, ticket1.ticketStatus());
        assertEquals(passenger1, ticket1.getPassenger());
    }

    @Test
    public void testSetterMethods() {
        ticket2.setTicket_id(3);
        ticket2.setPrice(2000);
        ticket2.setFlight(flight2);
        ticket2.setClassVip(false);
        ticket2.setTicketStatus(true);
        ticket2.setPassenger(passenger2);

        assertEquals(3, ticket2.getTicket_id());
        assertEquals(2240, ticket2.getPrice());
        assertEquals(flight2, ticket2.getFlight());
        assertEquals(false, ticket2.getClassVip());
        assertEquals(true, ticket2.ticketStatus());
        assertEquals(passenger2, ticket2.getPassenger());
    }

    @Test
    public void testToStringMethod() {
        String expectedString = "Ticket{" + '\n' +
            "Price=1120KZT, " + '\n' +
            "Flight{Airplane{model=Boeing 747', business sits=10', economy sits=200', crew sits=5'}, date to=2023-06-08 15:00:00.0, ', date from='2023-06-08 12:00:00.0', depart from='Melbourne', depart to='Sydney', code=QF001', company=Qantas', code=QF001'}" + '\n' + 
            "Vip status=true" + '\n' +
            "Passenger{ Fullname= Wells Yu ,email='cyuu0052@student.monash.edu', phoneNumber='0450 000 000', passport='123456789}" + '\n' + 
            "Ticket was purchased=false" + "\n}";
        assertEquals(expectedString, ticket1.toString());
    }

}

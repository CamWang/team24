package fit5171.monash.edu;

import fit5171.monash.edu.entity.Flight;
import fit5171.monash.edu.entity.Passenger;
import fit5171.monash.edu.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketTest {
    @Mock
    private Flight mockFlight;
    @Mock
    private Passenger mockPassenger;

    @BeforeEach
    void setUp() {
        mockFlight = mock(Flight.class);
        mockPassenger = mock(Passenger.class);
        when(mockPassenger.getAge()).thenReturn(22);
    }

    /**
     * 2. Discount is always applied based on the age category of the passenger.
     */
    @Test
    public void testSaleByAgeChild() {
        Passenger child = mock(Passenger.class);
        when(child.getAge()).thenReturn(10);
        Ticket childTicket = new Ticket(1, 100, mockFlight, false, child);
        assertEquals(50, childTicket.getPrice());
    }

    /**
     * 2. Discount is always applied based on the age category of the passenger.
     */
    @Test
    public void testSaleByAgeAdult() {
        Passenger adult = mock(Passenger.class);
        when(adult.getAge()).thenReturn(22);
        Ticket adultTicket = new Ticket(1, 100, mockFlight, false, adult);
        assertEquals(100, adultTicket.getPrice());
    }

    /**
     * 2. Discount is always applied based on the age category of the passenger.
     */
    @Test
    public void testSaleByAgeSenior() {
        Passenger senior = mock(Passenger.class);
        when(senior.getAge()).thenReturn(65);
        Ticket seniorTicket = new Ticket(1, 100, mockFlight, false, senior);
        assertEquals(0, seniorTicket.getPrice());
    }

    /**
     * 4. The price and service tax is a valid value (Integer or real numbers etc.)
     */
    @Test
    public void testServiceTax() {
        Ticket ticket = new Ticket(1, 100, mockFlight, false, mockPassenger);
        ticket.setPrice(100);
        ticket.setTicketStatus(true);
        ticket.serviceTax();
        assertEquals(112, ticket.getPrice(), 0.001);
    }

    @Test
    public void testGettersAndSetters() {
        Ticket ticket = new Ticket();
        ticket.setPassenger(mockPassenger);
        ticket.setFlight(mockFlight);
        ticket.setTicketId(1);
        ticket.setPrice(100);
        ticket.setClassVip(false);
        ticket.setTicketStatus(true);
        assertEquals(1, ticket.getTicketId());
        assertEquals(100, ticket.getPrice());
        assertEquals(mockFlight, ticket.getFlight());
        assertEquals(false, ticket.getClassVip());
        assertEquals(true, ticket.ticketStatus());
        assertEquals(mockPassenger, ticket.getPassenger());
    }

    @Test
    public void testToString() {
        Ticket ticket = new Ticket(1, 100, mockFlight, false, mockPassenger);
        String expectedString = "Ticket{\n" +
                "Price=100KZT, \n" +
                mockFlight.toString() + "\n" +
                "Vip status=false\n" +
                mockPassenger.toString() + "\n" +
                "Ticket was purchased=false\n" +
                "}";
        assertEquals(expectedString, ticket.toString());
    }
}

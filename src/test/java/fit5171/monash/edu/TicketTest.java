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
    public void testSaleByAgeChildTrue() {
        Passenger child = mock(Passenger.class);
        when(child.getAge()).thenReturn(10);
        Ticket childTicket = new Ticket(1, 100, mockFlight, false, child);
        childTicket.saleByAge(10);
        assertEquals(25, childTicket.getPrice());
    }

    @Test
    public void testSaleByAgeChildFalse() {
        Passenger child = mock(Passenger.class);
        when(child.getAge()).thenReturn(25);
        Ticket childTicket = new Ticket(1, 100, mockFlight, false, child);
        childTicket.saleByAge(25);
        assertEquals(100, childTicket.getPrice());
    }

    /**
     * 2. Discount is always applied based on the age category of the passenger.
     */
    @Test
    public void testSaleByAgeAdultTrue() {
        Passenger adult = mock(Passenger.class);
        when(adult.getAge()).thenReturn(22);
        Ticket adultTicket = new Ticket(1, 100, mockFlight, false, adult);
        adultTicket.saleByAge(22);
        assertEquals(100, adultTicket.getPrice());
    }

    @Test
    public void testSaleByAgeAdultFalse() {
        Passenger adult = mock(Passenger.class);
        when(adult.getAge()).thenReturn(70);
        Ticket adultTicket = new Ticket(1, 100, mockFlight, false, adult);
        adultTicket.saleByAge(70);
        assertEquals(0, adultTicket.getPrice());
    }

    /**
     * 2. Discount is always applied based on the age category of the passenger.
     */
    @Test
    public void testSaleByAgeSeniorTrue() {
        Passenger senior = mock(Passenger.class);
        when(senior.getAge()).thenReturn(65);
        Ticket seniorTicket = new Ticket(1, 100, mockFlight, false, senior);
        seniorTicket.saleByAge(65);
        assertEquals(0, seniorTicket.getPrice());
    }

    @Test
    public void testSaleByAgeSeniorFalse() {
        Passenger senior = mock(Passenger.class);
        when(senior.getAge()).thenReturn(27);
        Ticket seniorTicket = new Ticket(1, 100, mockFlight, false, senior);
        seniorTicket.saleByAge(27);
        assertEquals(100, seniorTicket.getPrice());
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
    void testServiceTaxWithTicketStatusIsTrue() {
        Ticket ticket = new Ticket();
        ticket.setPassenger(mockPassenger);
        ticket.setTicketStatus(true);
        ticket.setPrice(100);
        ticket.serviceTax();
        assertEquals(125.0, ticket.getPrice());
    }

    @Test
    void testServiceTaxWithTicketStatusIsFalse() {
        Ticket ticket = new Ticket();
        ticket.setPassenger(mockPassenger);
        ticket.setTicketStatus(false);
        ticket.setPrice(100);
        ticket.serviceTax();
        assertEquals(100.0, ticket.getPrice());
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
        assertFalse(ticket.getClassVip());
        assertTrue(ticket.getTicketStatus());
        assertEquals(mockPassenger, ticket.getPassenger());
    }

    @Test
    public void testGetterAndSetterWithParam() {
        Ticket ticket = new Ticket(1, 100, mockFlight, false, mockPassenger);
        assertEquals(mockPassenger, ticket.getPassenger());
        assertEquals(1, ticket.getTicketId());
        assertEquals(mockFlight, ticket.getFlight());
        assertEquals(100, ticket.getPrice());
        assertFalse(ticket.getClassVip());
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

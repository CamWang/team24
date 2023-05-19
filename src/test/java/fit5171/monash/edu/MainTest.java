package fit5171.monash.edu;

import fit5171.monash.edu.collection.FlightCollection;
import fit5171.monash.edu.collection.TicketCollection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testLoadData() throws Exception {
        Main.loadData();
        assertEquals(FlightCollection.flights.size(), 4);
        assertEquals(TicketCollection.tickets.size(), 8);
        FlightCollection.flights.clear();
        TicketCollection.tickets.clear();
    }
}

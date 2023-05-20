package fit5171.monash.edu;

import fit5171.monash.edu.collection.FlightCollection;
import fit5171.monash.edu.collection.TicketCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @BeforeEach
    @AfterEach
    public void cleanUp() {
        FlightCollection.flights.clear();
        TicketCollection.tickets.clear();
    }

    @Test
    public void testLoadData() throws Exception {
        Main.loadData();
        assertEquals(4, FlightCollection.flights.size());
        assertEquals( 8, TicketCollection.tickets.size());
    }

    @Test
    public void testMain() throws Exception {
        String testInput = "Melbourne\nSydney\n2\nChengHan\nYu\n27\nMan\ncyuu0052@student.monash.com\n" +
                "0450000000\n987654321\n1\n987654321\n987\n0";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        assertDoesNotThrow(() -> Main.main(new String[] {}));
    }
}

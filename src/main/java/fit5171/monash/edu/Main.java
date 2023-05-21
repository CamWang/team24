package fit5171.monash.edu;

import fit5171.monash.edu.collection.FlightCollection;
import fit5171.monash.edu.collection.TicketCollection;
import fit5171.monash.edu.entity.Airplane;
import fit5171.monash.edu.entity.Flight;
import fit5171.monash.edu.entity.Ticket;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private static final String FLIGHT_COMPANY = "Qantas";

    public static void loadData() throws ParseException {
        Airplane airplaneFirst = new Airplane(1, "A380", 50, 300, 8);
        Airplane airplaneSecond = new Airplane(2, "Bowening787-MAX", 30, 300, 10);

        Flight flightFirst = new Flight(1, "Sydney", "Melbourne", "QF485", FLIGHT_COMPANY, "16/07/23 12:12:12", "17/07/23 13:13:13", airplaneFirst);
        Flight flightSecond = new Flight(2, "ShangHai", "Perth", "QF075", FLIGHT_COMPANY, "02/08/23 14:14:14", "03/08/23 15:15:15", airplaneSecond);
        Flight flightThird = new Flight(3, "LosAngles", "Melbourne", "QF064", FLIGHT_COMPANY, "01/11/23 16:16:16", "02/11/23 17:17:17", airplaneFirst);
        Flight flightFourth = new Flight(4, "Paris", "LosAngles", "QF255", FLIGHT_COMPANY, "11/06/23 18:18:18", "13/06/23 19:19:19", airplaneFirst);

        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flightFirst);
        flights.add(flightSecond);
        flights.add(flightThird);
        flights.add(flightFourth);
        FlightCollection.addFlights(flights);

        Ticket ticketFirst = new Ticket(1, flightFirst, false);
        Ticket ticketSecond = new Ticket(2, flightFirst, true);
        Ticket ticketThird = new Ticket(3, flightSecond, false);
        Ticket ticketFourth = new Ticket(4, flightFourth, true);
        Ticket ticketFifth = new Ticket(5, flightThird, false);
        Ticket ticketSixth = new Ticket(6, flightThird, true);
        Ticket ticketSeventh = new Ticket(7, flightFourth, true);
        Ticket ticketEighth = new Ticket(8, flightFirst, false);
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(ticketFirst);
        tickets.add(ticketSecond);
        tickets.add(ticketThird);
        tickets.add(ticketFourth);
        tickets.add(ticketFifth);
        tickets.add(ticketSixth);
        tickets.add(ticketSeventh);
        tickets.add(ticketEighth);
        TicketCollection.addTickets(tickets);
    }
    public static void main(String[] args) throws Exception {
        loadData();
        TicketSystem ticketSystem = new TicketSystem();
        if (args.length == 1 && Objects.equals(args[0], "test")) {
            return;
        }
        ticketSystem.run();
    }
}

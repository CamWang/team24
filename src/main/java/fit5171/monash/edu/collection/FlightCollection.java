package fit5171.monash.edu.collection;

import fit5171.monash.edu.entity.Flight;

import java.util.ArrayList;

public class FlightCollection {

    public static ArrayList<Flight> flights = new ArrayList<>();

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static void addFlights(ArrayList<Flight> flights) throws IllegalArgumentException {
        for (Flight flight : flights) {
            if (FlightCollection.getFlightInfo(flight.getFlightID()) != null) {
                throw new IllegalArgumentException("Flight already exists");
            }
            if (!flight.getDepartTo().matches("[a-zA-Z]+") || !flight.getDepartFrom().matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("City can contain only small case and upper-case alphabet letters.");
            }
        }
        FlightCollection.flights.addAll(flights);
    }

    public static Flight getFlightInfo(String city1, String city2) {
        // display the flights where there is a direct flight from city 1 to city2
        for (Flight flight : flights) {
            if (flight.getDepartFrom().equals(city1) && flight.getDepartTo().equals(city2)) {
                return flight;
            }
        }
        return null;
    }

    public static Flight getFlightInfo(String city) {
        // SELECT a flight where depart_to = city
        for (Flight flight : flights) {
            if (flight.getDepartTo().equals(city)) {
                return flight;
            }
        }
        return null;

    }

    public static Flight getFlightInfo(int flight_id) {
        // SELECT a flight with a particular flight id
        for (Flight flight : flights) {
            if (flight.getFlightID() == flight_id) {
                return flight;
            }
        }
        return null;
    }
}

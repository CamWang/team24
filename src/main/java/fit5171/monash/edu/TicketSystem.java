package fit5171.monash.edu;

import java.sql.*;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.Scanner;

// public class TicketSystem<T> {
public class TicketSystem {
    Passenger passenger;
    Ticket ticket = new Ticket();
    Flight flight = new Flight();
    Scanner in = new Scanner(System.in);

    private FlightCollection flightCollection;
    private TicketCollection ticketCollection;

    public TicketSystem() {
        passenger = new Passenger("null", "null", 1, "Other");
        ticket = new Ticket();
        flight = new Flight();
        flightCollection = new FlightCollection();
        ticketCollection = new TicketCollection();
    }

    public TicketCollection getTicketCollection()
    {
        return ticketCollection;
    }

    public void buyTicket(int ticket_id) throws Exception
    // method for buying one ticket with direct flight
    {
        int flight_id = 0;

        // select ticket where ticket_id="+ticket_id"
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message
        if (validTicket == null) {
            throw new RuntimeException("This ticket does not exist.");
            // return;
        } else {
            // select flight_id from ticket where ticket_id=" + ticket_id

            flight_id = validTicket.getFlight().getFlightID();

            try {
                System.out.println("Enter your First Name: ");
                String firstName = in.nextLine();
                passenger.setFirstName(firstName);

                System.out.println("Enter your Second name:");
                String secondName = in.nextLine();
                passenger.setSecondName(secondName);

                System.out.println("Enter your age:");
                int age = 1;
                try {
                    age = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Age must be a integer.");
                }
                passenger.setAge(age);

                System.out.println("Enter your gender: ");
                String gender = in.nextLine();
                passenger.setGender(gender);

                System.out.println("Enter your e-mail address");
                String email = in.nextLine();
                passenger.setEmail(email);

                System.out.println("Enter your phone number (+7):");
                String phoneNumber = in.nextLine();
                passenger.setPhoneNumber(phoneNumber);

                System.out.println("Enter your passport number:");
                String passportNumber = in.nextLine();
                passenger.setPassport(passportNumber);

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purchase = Integer.parseInt(in.nextLine());
                if (purchase == 0) {
                    return;
                } else {

                    flight = FlightCollection.getFlightInfo(flight_id);

//                    int airplane_id = flight.getAirplane().getAirplaneID();
                    Airplane airplane = flight.getAirplane();
//                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                    ticket = TicketCollection.getTicketInfo(ticket_id);

                    ticket.setPassenger(passenger);
                    ticket.setTicket_id(ticket_id);
                    ticket.setFlight(flight);
                    ticket.setPrice(ticket.getPrice());
                    ticket.setClassVip(ticket.getClassVip());
                    ticket.setTicketStatus(true);
                    if (ticket.getClassVip()) {
                        airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                    } else {
                        airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                    }

                }
                System.out.println("Your bill: " + ticket.getPrice() + "\n");

                System.out.println("Enter your card number:");
                String cardNumber = in.nextLine();
                passenger.setCardNumber(cardNumber);

                System.out.println("Enter your security code:");
                int securityCode = Integer.parseInt(in.nextLine());
                passenger.setSecurityCode(securityCode);

            } catch (PatternSyntaxException patternException) {
                patternException.printStackTrace();
            }
        }
    }

    @SuppressWarnings("null")
    public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception {
        // method for buying two tickets with transfer flight
        int flight_id_first = 0;

        int flight_id_second = 0;

        System.out.println(ticket_id_first + " " + ticket_id_second);

        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticket_id_first);

        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_first);

        System.out.println("Processing...");

        //Display error message when a passenger choose an already booked ticket
        if (validTicketFirst.ticketStatus() || validTicketSecond.ticketStatus())
        {
            System.out.println("This ticket is already booked.");
            return;
        }

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message

        if (validTicketFirst != null || validTicketSecond != null) {
            System.out.println("This ticket does not exist.");
            return;
        }

        else {
            flight_id_first = validTicketFirst.getFlight().getFlightID();

            flight_id_second = validTicketFirst.getFlight().getFlightID();

            try {
                System.out.println("Enter your First Name: ");
                String firstName = "";
                passenger.setFirstName(firstName);

                System.out.println("Enter your Second name:");
                String secondName = "";
                passenger.setSecondName(secondName); // setting passengers info

                System.out.println("Enter your age:");
                Integer age = 0;
                in.nextLine();
                passenger.setAge(age);

                System.out.println("Enter your gender: ");
                String gender = "";
                // passenger.setGender(gender));

                System.out.println("Enter your e-mail address");
                String email = "";
                passenger.setEmail(email);

                System.out.println("Enter your phone number (+7):");
                String phoneNumber = "";
                passenger.setPhoneNumber(phoneNumber);

                System.out.println("Enter your passport number:");
                String passportNumber = "";
                passenger.setPassport(passportNumber);

                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purch = in.nextInt();
                if (purch == 0)
                {
                    return;
                } else {

                    // "select * from flight, airplane where flight_id=" + flight_id_first + " and
                    // flight.airplane_id=airplane.airplane_id");
                    Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);

//                    int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                    Airplane airplane_first = flight_first.getAirplane();
//                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);

                    Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);

//                    int airplane_id_second = flight_second.getAirplane().getAirplaneID();
                    Airplane airplane_second = flight_second.getAirplane();
//                    Airplane airplane_second = Airplane.getAirPlaneInfo(airplane_id_second);

                    Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);

                    Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);

                    ticket_first.setPassenger(passenger);
                    ticket_first.setTicket_id(ticket_id_first);
                    ticket_first.setFlight(flight_first);
                    ticket_first.setPrice(ticket_first.getPrice());
                    ticket_first.setClassVip(ticket_first.getClassVip());
                    ticket_first.setTicketStatus(true);

                    if (ticket_first.getClassVip()) {
                        airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                    } else {
                        airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket_second.setPassenger(passenger);
                    ticket_second.setTicket_id(ticket_id_second);
                    ticket_second.setFlight(flight_first);
                    ticket_second.setPrice(ticket_second.getPrice());
                    ticket_second.setClassVip(ticket_second.getClassVip());
                    ticket_second.setTicketStatus(true);
                    if (ticket_second.getClassVip()) {
                        airplane_second.setBusinessSitsNumber(airplane_second.getBusinessSitsNumber() - 1);
                    } else {
                        airplane_second.setEconomySitsNumber(airplane_second.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*-");

                    ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());

                    System.out.println("Your bill: " + ticket.getPrice() + "\n");

                    System.out.println("Enter your card number:");

                    String cardNumber = "";
                    passenger.setCardNumber(cardNumber);

                    System.out.println("Enter your security code:");
                    int securityCode = 0;
                    passenger.setSecurityCode(securityCode);

                }
            } catch (PatternSyntaxException patternException) {
                patternException.printStackTrace();
            }
        }

    }

    public void chooseTicket(String city1, String city2) throws Exception {
        int counter = 1;
        int idFirst = 0;
        int idSecond = 0;

//        Flight flight = new Flight();

        // search for direct flight from city1 to city2

        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        if (flight != null) {

            TicketCollection.getAllTickets();

            System.out.println("\nEnter ID of ticket you want to choose:");
            int ticket_id = 1;
            try {
                ticket_id = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
            // validate ticker here
            if(TicketCollection.getTicketInfo(ticket_id) == null){
                throw new Exception("This ticket does not exist.");
            } else if(TicketCollection.getTicketInfo(ticket_id).ticketStatus()) {
                throw new Exception("This ticket is already booked.");
            }


            // buy ticket here
            buyTicket(ticket_id);
        } else
        // in case there is no direct ticket from city1 to city2
        {
            // SELECT a flight where depart_to = city2

            Flight depart_to = FlightCollection.getFlightInfo(city2);

            // and search for city with depart_from as connector city

            String connectCity = depart_to.getDepartFrom();

            // SELECT * from flight where depart_to = '" + connectCity + "' and depart_from
            // = '" + city1+"'"

            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

            if (flightConnectingTwoCities != null) {

                System.out.println(
                        "There is special way to go there. And it is transfer way, like above. Way №" + counter);

                idFirst = depart_to.getFlightID();

                idSecond = flightConnectingTwoCities.getFlightID();
                buyTicket(idFirst, idSecond); // pass two tickets and buy them
                counter++;
            }

            if (counter == 1) {
                System.out.println("There is no possible variants.");
            }
            return;
        }

    }

    public void showTicket() {
        try {
            System.out.println("You have bought a ticket for flight " + ticket.flight.getDepartFrom() + " - "
                    + ticket.flight.getDepartTo() + "\n\nDetails:");
            System.out.println(this.ticket.toString());
        } catch (NullPointerException e) {
            return;
        }
    }

}

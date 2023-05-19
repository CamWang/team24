package fit5171.monash.edu;

import fit5171.monash.edu.collection.*;
import fit5171.monash.edu.entity.*;

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

    public void buyTicket(int ticketId) throws Exception
    // method for buying one ticket with direct flight
    {
        int flight_id = 0;

        // select ticket where ticket_id="+ticket_id"
        Ticket validTicket = TicketCollection.getTicketInfo(ticketId);

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message
        if (validTicket == null) {
            throw new RuntimeException("This ticket does not exist.");
            // return;
        } else {
            // select flight_id from ticket where ticket_id=" + ticket_id

            flight_id = validTicket.getFlight().getFlightID();

            try {
                setPassengerInformation();
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int purchase = Integer.parseInt(in.nextLine());
                if (purchase == 0) {
                    return;
                } else {

                    flight = FlightCollection.getFlightInfo(flight_id);

//                    int airplane_id = flight.getAirplane().getAirplaneID();
                    Airplane airplane = flight.getAirplane();
//                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                    ticket = TicketCollection.getTicketInfo(ticketId);

                    setTicketInformation(ticketId);
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
    public void buyTicket(int ticketIdFirst, int ticketIdSecond) throws Exception {
        // method for buying two tickets with transfer flight
        int flightIdFirst = 0;
        int flightIdSecond = 0;

        System.out.println(ticketIdFirst + " " + ticketIdSecond);
        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticketIdFirst);
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticketIdFirst);
        System.out.println("Processing...");

        //Display error message when a passenger choose an already booked ticket
        /*if (validTicketFirst.ticketStatus() || validTicketSecond.ticketStatus())
        {
            System.out.println("This ticket is already booked.");
            return;
        }*/

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message

        if (validTicketFirst == null || validTicketSecond == null) {
            System.out.println("At least one ticket does not exist.");
            return;
        }
        else {
            flightIdFirst = validTicketFirst.getFlight().getFlightID();
            flightIdSecond = validTicketFirst.getFlight().getFlightID();

            try {
                setPassengerInformation();
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");
                int confirmCode = in.nextInt();
                if (confirmCode == 0)
                {
                    return;
                } else {
                    // "select * from flight, airplane where flight_id=" + flight_id_first + " and
                    // flight.airplane_id=airplane.airplane_id");
                    Flight flightFirst = FlightCollection.getFlightInfo(flightIdFirst);

//                    int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                    Airplane airplaneFirst = flightFirst.getAirplane();
//                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);

                    Flight flightSecond = FlightCollection.getFlightInfo(flightIdSecond);

//                    int airplane_id_second = flight_second.getAirplane().getAirplaneID();
                    Airplane airplaneSecond = flightSecond.getAirplane();
//                    Airplane airplane_second = Airplane.getAirPlaneInfo(airplane_id_second);

                    Ticket ticketFirst = TicketCollection.getTicketInfo(ticketIdFirst);

                    Ticket ticketSecond = TicketCollection.getTicketInfo(ticketIdSecond);

                    setTicketInformation(ticketFirst, ticketIdFirst, flightFirst);
                    if (ticketFirst.getClassVip()) {
                        airplaneFirst.setBusinessSitsNumber(airplaneFirst.getBusinessSitsNumber() - 1);
                    } else {
                        airplaneFirst.setEconomySitsNumber(airplaneFirst.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*--");

                    setTicketInformation(ticketSecond, ticketIdSecond, flightSecond);
                    if (ticketSecond.getClassVip()) {
                        airplaneSecond.setBusinessSitsNumber(airplaneSecond.getBusinessSitsNumber() - 1);
                    } else {
                        airplaneSecond.setEconomySitsNumber(airplaneSecond.getEconomySitsNumber() - 1);
                    }

                    System.out.println("--*-*--");

                    ticket.setPassenger(passenger);
                    ticket.setPrice(ticketFirst.getPrice() + ticketSecond.getPrice());
                    System.out.println("Your bill: " + ticket.getPrice() + "\n");
                    System.out.println("Enter your card number:");
                    String random = in.nextLine(); // Consume newline left-over
                    String cardNumber = in.nextLine();
                    passenger.setCardNumber(cardNumber);

                    System.out.println("Enter your security code:");
                    int securityCode = in.nextInt();
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

            assert depart_to != null;
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

    public void setPassengerInformation(){
        System.out.println("Please, enter your first name:");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);
        System.out.println("Please, enter your second name:");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName);
        System.out.println("Please, enter your age:");
        int age = 1;
        try {
            age = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Age must be an integer.");
        }
        passenger.setAge(age);
        System.out.println("Please, enter your gender:");
        String gender = in.nextLine();
        passenger.setGender(gender);
        System.out.println("Please, enter your email address:");
        String email = in.nextLine();
        passenger.setEmail(email);
        System.out.println("Please, enter your phone number:");
        String phoneNo = in.nextLine();
        passenger.setPhoneNumber(phoneNo);
        System.out.println("Please, enter your passport number:");
        String passportNumber = in.nextLine();
        passenger.setPassport(passportNumber);
        //passenger = new Passenger(firstName, secondName, passportNumber, phoneNumber, email, address, passportNumber);
    }

    public void setTicketInformation(int ticketId){
        ticket.setPassenger(passenger);
        ticket.setTicket_id(ticketId);
        ticket.setFlight(flight);
        ticket.setPrice(ticket.getPrice());
        ticket.setClassVip(ticket.getClassVip());
        ticket.setTicketStatus(true);
    }

    public void setTicketInformation(Ticket ticket, int ticketId, Flight flight){
        ticket.setPassenger(passenger);
        ticket.setTicket_id(ticketId);
        ticket.setFlight(flight);
        ticket.setPrice(ticket.getPrice());
        ticket.setClassVip(ticket.getClassVip());
        ticket.setTicketStatus(true);
    }

    public void run() throws Exception{
        while(true){
            System.out.println("Welcome to the Arline Ticket Booking System!");
            System.out.println("Please, enter the departure city:");
            String departCity = in.nextLine();
            System.out.println("Please, enter the destination city:");
            String destCity = in.nextLine();
            chooseTicket(departCity, destCity);
            showTicket();
            System.out.println("Do you want to buy another tickets?\n 1-YES 0-NO");
            int confirmCode = in.nextInt();
            if (confirmCode == 0)
            {
                System.out.println("Thank you for using our system!");
                break;
            }
        }
    }

    public void showTicket() {
        System.out.println("You have bought a ticket for flight " + ticket.getFlight().getDepartFrom() + " - "
                + ticket.getFlight().getDepartTo() + "\n\nDetails:");
        System.out.println(this.ticket.toString());
    }

}



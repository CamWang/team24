package fit5171.monash.edu;

import fit5171.monash.edu.collection.*;
import fit5171.monash.edu.entity.*;

import java.util.Scanner;

public class TicketSystem {
    Passenger passenger;
    Ticket ticket;
    Flight flight;
    Scanner in = new Scanner(System.in);

    public TicketSystem() {
        passenger = new Passenger("null", "null", 1, "Other");
        ticket = new Ticket();
        flight = new Flight();
    }

    public void buyTicket(int ticketId)
    // method for buying one ticket with direct flight
    {
        int flightId;

        // select ticket where ticket_id="+ticket_id"
        Ticket validTicket = TicketCollection.getTicketInfo(ticketId);

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message
        if (validTicket == null) {
            throw new RuntimeException("This ticket does not exist.");
        } else {
            // select flightId from ticket where ticket_id=" + ticket_id
            flightId = validTicket.getFlight().getFlightID();
            setPassengerInformation();
            Util.log("Do you want to purchase?\n 1-YES 0-NO");
            int purchase = Integer.parseInt(in.nextLine());
            if (purchase == 0) {
                return;
            } else {

                flight = FlightCollection.getFlightInfo(flightId);

                Airplane airplane = flight.getAirplane();

                ticket = TicketCollection.getTicketInfo(ticketId);

                setTicketInformation(ticketId);
                if (ticket.getClassVip()) {
                    airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                } else {
                    airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                }

            }
            Util.log("Your bill: " + ticket.getPrice() + "\n");

            Util.log("Enter your card number:");
            String cardNumber = in.nextLine();
            passenger.setCardNumber(cardNumber);

            Util.log("Enter your security code:");
            int securityCode = Integer.parseInt(in.nextLine());
            passenger.setSecurityCode(securityCode);
        }
    }

    @SuppressWarnings("null")
    public void buyTicket(int ticketIdFirst, int ticketIdSecond) {
        // method for buying two tickets with transfer flight
        int flightIdFirst;
        int flightIdSecond;

        Util.log(ticketIdFirst + " " + ticketIdSecond);
        Ticket validTicketFirst = TicketCollection.getTicketInfo(ticketIdFirst);
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticketIdFirst);
        Util.log("Processing...");

        // if there is a valid ticket id was input then we buy it, otherwise show
        // message
        if (validTicketFirst == null || validTicketSecond == null) {
            Util.log("At least one ticket does not exist.");
        } else {
            flightIdFirst = validTicketFirst.getFlight().getFlightID();
            flightIdSecond = validTicketFirst.getFlight().getFlightID();

            setPassengerInformation();
            Util.log("Do you want to purchase?\n 1-YES 0-NO");
            int confirmCode = in.nextInt();
            if (confirmCode != 0) {
                // "select * from flight, airplane where flight_id=" + flight_id_first + " and
                // flight.airplane_id=airplane.airplane_id");
                Flight flightFirst = FlightCollection.getFlightInfo(flightIdFirst);
                Airplane airplaneFirst = flightFirst.getAirplane();
                Flight flightSecond = FlightCollection.getFlightInfo(flightIdSecond);
                Airplane airplaneSecond = flightSecond.getAirplane();
                Ticket ticketFirst = TicketCollection.getTicketInfo(ticketIdFirst);
                Ticket ticketSecond = TicketCollection.getTicketInfo(ticketIdSecond);
                setTicketInformation(ticketFirst, ticketIdFirst, flightFirst);
                if (ticketFirst.getClassVip()) {
                    airplaneFirst.setBusinessSitsNumber(airplaneFirst.getBusinessSitsNumber() - 1);
                } else {
                    airplaneFirst.setEconomySitsNumber(airplaneFirst.getEconomySitsNumber() - 1);
                }

                Util.log("--*-*--");

                setTicketInformation(ticketSecond, ticketIdSecond, flightSecond);
                if (ticketSecond.getClassVip()) {
                    airplaneSecond.setBusinessSitsNumber(airplaneSecond.getBusinessSitsNumber() - 1);
                } else {
                    airplaneSecond.setEconomySitsNumber(airplaneSecond.getEconomySitsNumber() - 1);
                }

                Util.log("--*-*--");

                ticket.setPassenger(passenger);
                ticket.setPrice(ticketFirst.getPrice() + ticketSecond.getPrice());
                Util.log("Your bill: " + ticket.getPrice() + "\n");
                Util.log("Enter your card number:");
                in.nextLine(); // Consume newline left-over
                String cardNumber = in.nextLine();
                passenger.setCardNumber(cardNumber);

                Util.log("Enter your security code:");
                int securityCode = in.nextInt();
                passenger.setSecurityCode(securityCode);
            }
        }

    }

    public void chooseTicket(String city1, String city2) throws Exception {
        int counter = 1;
        int idFirst;
        int idSecond;

        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        if (flight != null) {

            TicketCollection.getAllTickets();

            Util.log("\nEnter ID of ticket you want to choose:");
            int ticket_id = 1;
            try {
                ticket_id = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                Util.log("Please enter a valid number");
            }
            // validate ticker here
            if (TicketCollection.getTicketInfo(ticket_id) == null) {
                throw new Exception("This ticket does not exist.");
            } else if (TicketCollection.getTicketInfo(ticket_id).ticketStatus()) {
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

                Util.log(
                        "There is special way to go there. And it is transfer way, like above. Way №" + counter);

                idFirst = depart_to.getFlightID();

                idSecond = flightConnectingTwoCities.getFlightID();
                buyTicket(idFirst, idSecond); // pass two tickets and buy them
                counter++;
            }

            if (counter == 1) {
                Util.log("There is no possible variants.");
            }
        }
    }

    public void setPassengerInformation() {
        Util.log("Please, enter your first name:");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);
        Util.log("Please, enter your second name:");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName);
        Util.log("Please, enter your age:");
        int age;
        try {
            age = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Age must be an integer.");
        }
        passenger.setAge(age);
        Util.log("Please, enter your gender:");
        String gender = in.nextLine();
        passenger.setGender(gender);
        Util.log("Please, enter your email address:");
        String email = in.nextLine();
        passenger.setEmail(email);
        Util.log("Please, enter your phone number:");
        String phoneNo = in.nextLine();
        passenger.setPhoneNumber(phoneNo);
        Util.log("Please, enter your passport number:");
        String passportNumber = in.nextLine();
        passenger.setPassport(passportNumber);
        //passenger = new Passenger(firstName, secondName, passportNumber, phoneNumber, email, address, passportNumber);
    }

    public void setTicketInformation(int ticketId) {
        ticket.setPassenger(passenger);
        ticket.setTicket_id(ticketId);
        ticket.setFlight(flight);
        ticket.setPrice(ticket.getPrice());
        ticket.setClassVip(ticket.getClassVip());
        ticket.setTicketStatus(true);
    }

    public void setTicketInformation(Ticket ticket, int ticketId, Flight flight) {
        ticket.setPassenger(passenger);
        ticket.setTicket_id(ticketId);
        ticket.setFlight(flight);
        ticket.setPrice(ticket.getPrice());
        ticket.setClassVip(ticket.getClassVip());
        ticket.setTicketStatus(true);
    }

    public void run() throws Exception {
        while (true) {
            Util.log("Welcome to the Arline Ticket Booking System!");
            Util.log("Please, enter the departure city:");
            String departCity = in.nextLine();
            Util.log("Please, enter the destination city:");
            String destCity = in.nextLine();
            chooseTicket(departCity, destCity);
            showTicket();
            Util.log("Do you want to buy another tickets?\n 1-YES 0-NO");
            int confirmCode = in.nextInt();
            if (confirmCode == 0) {
                Util.log("Thank you for using our system!");
                break;
            }
        }
    }

    public void showTicket() {
        Util.log("You have bought a ticket for flight " + ticket.getFlight().getDepartFrom() + " - "
                + ticket.getFlight().getDepartTo() + "\n\nDetails:");
        Util.log(this.ticket.toString());
    }

}



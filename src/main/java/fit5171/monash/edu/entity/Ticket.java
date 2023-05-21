package fit5171.monash.edu.entity;

public class Ticket {
    private int ticketId;
    private int price;
    Flight flight;
    private boolean classVip; // indicates if this is bussiness class ticket or not
    private boolean status; // indicates status of ticket: if it is bought by someone or not
    Passenger passenger;

    public Ticket(int ticketId, int price, Flight flight, boolean classVip, Passenger passenger) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.classVip = classVip;
        this.status = false;
        this.passenger = passenger;
        this.setPrice(price);
    }

    public Ticket() {

    }

    public Ticket(int ticketId, Flight flightFirst, boolean classVip) {
        this.ticketId = ticketId;
        this.flight = flightFirst;
        this.classVip = classVip;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        saleByAge(passenger.getAge()); // changes price of the ticket according to the age category of passenger
        serviceTax(); // changes price by adding service tax to the ticket
    }

    public void saleByAge(int age) {
        int currentPrice = getPrice();
        if (age < 15) {
            currentPrice -= (int) currentPrice * 0.5;// 50% sale for children under 15
            this.price = currentPrice;

        } else if (age >= 60) {
            this.price = 0; // 100% sale for elder people
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean getClassVip() {
        return classVip;
    }

    public void setClassVip(boolean classVip) {
        this.classVip = classVip;
    }

    public boolean getTicketStatus() {
        return status;
    }

    public void setTicketStatus(boolean status) {
        this.status = status;
    }

    public void serviceTax() {
        if (getTicketStatus()) {
            this.price *= 1.12;
        }
    } // 12% service tax

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String toString() {
        return "Ticket{" + '\n' +
                "Price=" + getPrice() + "KZT, " + '\n' +
                getFlight() + '\n' + "Vip status=" + getClassVip() + '\n' +
                getPassenger() + '\n' + "Ticket was purchased=" + getTicketStatus() + "\n}";
    }
}

package fit5171.monash.edu;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    Airplane airplane;

    public Flight() {
    }

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,
            Timestamp dateTo, Airplane airplane) throws IllegalArgumentException {
        if (FlightCollection.getFlightInfo(flight_id)!=null) {
            throw new IllegalArgumentException("Flight ID already exists");
        }
        this.flightID = flight_id;
        this.departTo = departTo;
        this.departFrom = departFrom;
        this.code = code;
        this.company = company;
        this.airplane = airplane;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;

    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flight_id) {
        this.flightID = flight_id;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) throws IllegalArgumentException, ParseException {
        String[] dateString = dateFrom.split(" ");
        if (!dateString[0].matches("\\d{2}\\/\\d{2}\\/\\d{2}")) {
            throw new IllegalArgumentException("Date format must be DD/MM/YY");
        } else if (!dateString[1].matches("\\d{2}\\:\\d{2}\\:\\d{2}")){
            throw new IllegalArgumentException("Time format must be HH:MM:SS");
        }
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = inputFormat.parse(dateFrom);
        Timestamp timestamp = new Timestamp(date.getTime());
        this.dateFrom = timestamp;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) throws IllegalArgumentException, ParseException {
        String[] dateString = dateTo.split(" ");
        if (!dateString[0].matches("\\d{2}\\/\\d{2}\\/\\d{2}")) {
            throw new IllegalArgumentException("Date format must be DD/MM/YY");
        } else if (!dateString[1].matches("\\d{2}\\:\\d{2}\\:\\d{2}")){
            throw new IllegalArgumentException("Time format must be HH:MM:SS");
        }
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = inputFormat.parse(dateTo);
        Timestamp timestamp = new Timestamp(date.getTime());
        this.dateTo = timestamp;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString() {
        return "Flight{" + airplane.toString() +
                ", date to=" + getDateTo() + ", " + '\'' +
                ", date from='" + getDateFrom() + '\'' +
                ", depart from='" + getDepartFrom() + '\'' +
                ", depart to='" + getDepartTo() + '\'' +
                ", company=" + getCompany() + '\'' +
                ", code=" + getCode() + '\'' +
                '}';
    }
}

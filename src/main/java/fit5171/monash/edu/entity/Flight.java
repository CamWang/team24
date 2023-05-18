package fit5171.monash.edu.entity;

import fit5171.monash.edu.entity.Airplane;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Airplane airplane;

    public Flight() {
    }

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, String dateFrom,
                  String dateTo, Airplane airplane) throws ParseException {
        this.flightID = flight_id;
        this.departTo = departTo;
        this.departFrom = departFrom;
        this.code = code;
        this.company = company;
        this.airplane = airplane;
        setDateFrom(dateFrom);
        setDateTo(dateTo);
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

    public String getDateFrom() {
        return DATE_FORMAT.format(dateFrom);
    }

    public void setDateFrom(String dateFrom) throws IllegalArgumentException, ParseException {
        String[] dateString = dateFrom.split(" ");
        if (!dateString[0].matches("\\d{2}/\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("Date format must be DD/MM/YY");
        } else if (!dateString[1].matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time format must be HH:MM:SS");
        }
        this.dateFrom = new Timestamp(DATE_FORMAT.parse(dateFrom).getTime());
    }

    public String getDateTo() {
        return DATE_FORMAT.format(dateTo);
    }

    public void setDateTo(String dateTo) throws IllegalArgumentException, ParseException {
        String[] dateString = dateTo.split(" ");
        if (!dateString[0].matches("\\d{2}/\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("Date format must be DD/MM/YY");
        } else if (!dateString[1].matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Time format must be HH:MM:SS");
        }
        this.dateTo = new Timestamp(DATE_FORMAT.parse(dateTo).getTime());
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

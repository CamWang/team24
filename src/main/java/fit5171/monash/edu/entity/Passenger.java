package fit5171.monash.edu.entity;

import java.util.regex.Pattern;

public class Passenger extends Person {
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private int securityCode;
    private String passport;
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\+61|0)?[45]\\d{8}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$");
    private static final Pattern PASSPORT_NUMBER_PATTERN = Pattern.compile("\\d{9}");
    public Passenger(String firstName, String secondName, int age, String gender) {
        super(firstName, secondName, age, gender);
    }

    public Passenger(String firstName, String secondName, int age, String gender, String email, String phoneNumber,
            String passport, String cardNumber, int securityCode) {
        super(firstName, secondName, age, gender);
        this.securityCode = securityCode;
        this.cardNumber = cardNumber;
        setPassport(passport);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Wrong email format");
        }
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setPassport(String passport) throws IllegalArgumentException {
        if (!PASSPORT_NUMBER_PATTERN.matcher(passport).matches()) {
            throw new IllegalArgumentException("Wrong passport number format");
        }
        this.passport = passport;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException{
        if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Wrong phone number format");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" + " Fullname= " + super.getFirstName() + " " + super.getSecondName() +
                " ,email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport +
                '}';
    }
}

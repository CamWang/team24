package fit5171.monash.edu.entity;



import java.util.Arrays;
import java.util.List;

import static fit5171.monash.edu.entity.Person.Gender.*;

public abstract class Person // abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private Gender gender;

    private static final String WOMAN_STR = "Woman";
    private static final String MAN_STR = "Man";
    private static final String NON_BINARY_STR = "Non-binary|gender diverse";
    private static final String PREFER_NOT_TO_SAY_STR = "Prefer not to say";
    private static final String OTHER_STR = "Other";

    public Person(String firstName, String secondName, int age, String gender) throws IllegalArgumentException {
        this.age = age;
        setFirstName(firstName);
        setSecondName(secondName);
        setGender(gender);
    }
    public enum Gender {
        WOMAN,
        MAN,
        NON_BINARY,
        PREFER_NOT_TO_SAY,
        OTHER
    }

    public String getGenderString(Enum<Gender> gender) {
        if (gender.equals(WOMAN)) {
            return WOMAN_STR;
        } else if (gender.equals(MAN)) {
            return MAN_STR;
        } else if (gender.equals(NON_BINARY)) {
            return NON_BINARY_STR;
        } else if (gender.equals(PREFER_NOT_TO_SAY)) {
            return PREFER_NOT_TO_SAY_STR;
        } else {
            return OTHER_STR;
        }
    }

    public Gender getGenderEnum(String genderStr) {
        switch(genderStr) {
            case WOMAN_STR:
                return WOMAN;
            case MAN_STR:
                return MAN;
            case NON_BINARY_STR:
                return NON_BINARY;
            case PREFER_NOT_TO_SAY_STR:
                return PREFER_NOT_TO_SAY;
            default:
                return OTHER;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return getGenderString(gender);
    }

    public void setGender(String genderStr) throws IllegalArgumentException{
        List<String> genderList = Arrays.asList(WOMAN_STR, MAN_STR, NON_BINARY_STR, PREFER_NOT_TO_SAY_STR, OTHER_STR);
        if (!genderList.contains(genderStr)) {
            throw new IllegalArgumentException("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.");
        }
        this.gender = getGenderEnum(genderStr);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (!firstName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name can contain only small case and upper-case alphabet letters.");
        }
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) throws IllegalArgumentException {
        if (!secondName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name can contain only small case and upper-case alphabet letters.");
        }
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

package fit5171.monash.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Person // abstract class Person
{
    private String firstName;
    private String secondName;
    private int age;
    private Gender gender;

    public Person() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        String genderStr = "";
        switch(gender) {
            case WOMAN:
                genderStr = "Woman";
                break;
            case MAN:
                genderStr = "Man";
                break;
            case NON_BINARY:
                genderStr = "Non-binary|gender diverse";
                break;
            case PREFER_NOT_TO_SAY:
                genderStr = "Prefer not to say";
                break;
            case OTHER:
                genderStr = "Other";
                break;
        }
        return genderStr;
    }

    public void setGender(String genderStr) throws IllegalArgumentException{
        List<String> genderList = Arrays.asList("Woman", "Man", "Non-binary|gender diverse", "Prefer not to say", "Other");
        if (!genderList.contains(genderStr)) {
            throw new IllegalArgumentException("Gender option: Woman, Man, Non-binary|gender diverse, Prefer not to say and Other.");
        }
        Gender gender = null;
        switch(genderStr) {
            case "Woman":
                gender = Gender.WOMAN;
                break;
            case "Man":
                gender = Gender.MAN;
                break;
            case "Non-binary|gender diverse":
                gender = Gender.NON_BINARY;
                break;
            case "Prefer not to say":
                gender = Gender.PREFER_NOT_TO_SAY;
                break;
            case "Other":
                gender = Gender.OTHER;
                break;
        }
        this.gender = gender;
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

package fit5171.monash.edu;

public class Airplane {
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber,
            int crewSitsNumber) {
        this.airplaneID = airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) throws IllegalArgumentException{
        if (businessSitsNumber < 1) {
            throw new IllegalArgumentException("Business sits number cannot be less than 1");
        }
        else if (businessSitsNumber > 300) {
            throw new IllegalArgumentException("Business sits number cannot be greater than 300");
        }
        this.businessSitsNumber = businessSitsNumber;
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economSitsNumber) throws IllegalArgumentException{
        if (economSitsNumber < 1) {
            throw new IllegalArgumentException("Economy sits number cannot be less than 1");
        }
        else if (economSitsNumber > 300) {
            throw new IllegalArgumentException("Economy sits number cannot be greater than 300");
        }
        this.economySitsNumber = economSitsNumber;
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) throws IllegalArgumentException{
        if (crewSitsNumber < 1) {
            throw new IllegalArgumentException("Crew sits number cannot be less than 1");
        }
        else if (crewSitsNumber > 300) {
            throw new IllegalArgumentException("Crew sits number cannot be greater than 300");
        }
        this.crewSitsNumber = crewSitsNumber;
    }

    public String toString() {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }

    public static Airplane getAirPlaneInfo(int airplaneID) {
        // TODO Auto-generated method stub
        return null;
    }
}
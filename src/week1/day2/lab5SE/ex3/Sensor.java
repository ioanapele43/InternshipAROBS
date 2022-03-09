package week1.day2.lab5SE.ex3;

public abstract class Sensor {
    private String location;
    public abstract int readValue();
    public String getLocation(){
        return this.location;
    }
}

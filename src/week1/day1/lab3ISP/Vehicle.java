package week1.day1.lab3ISP;

public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    public Vehicle(String m, String t, int s, char f){
        model=m;
        type=t;
        speed=s;
        fuelType=f;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return   model+"("+type+") speed "+speed+" fuel type "+fuelType;
    }
    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(!(o instanceof Vehicle)){
            return false;
        }
        Vehicle c=(Vehicle) o;
        return this.model==c.model && this.type==c.type && this.speed==c.speed && this.fuelType==c.fuelType;

    }
}

package week1.day3.lab7.ex4;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private int price;
    public Car(String model,int price){
        this.model=model;
        this.price=price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

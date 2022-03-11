package week1.day3.lab7.ex4;

import java.io.*;

public class SerializationDeserialization {
    public static void serialization(Car car){
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\week1\\day3\\lab7\\ex4\\car.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(car);
            out.close();
            fileOut.close();
           
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static Car deserializatin(){
        Car car=null;
        try {
            FileInputStream fileIn = new FileInputStream("src\\week1\\day3\\lab7\\ex4\\car.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            car = (Car) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Car class not found");
            c.printStackTrace();
            return null;
        }
        return car;
    }
    public static void main(String[] args){
        Car car=new Car("Dacia",10000);
        serialization(car);
        Car newCar=deserializatin();
        System.out.println("initial data of car: model "+car.getModel()+ " amd price "+car.getPrice());
        System.out.println("deserialized data of car: model "+newCar.getModel()+ " amd price "+newCar.getPrice());
    }
}

package week1.day2.lab5SE.ex3;

import java.util.Random;

public class LightSensor extends Sensor{

    @Override
    public int readValue() {
        Random rand=new Random();
        return rand.nextInt(101);
    }
}

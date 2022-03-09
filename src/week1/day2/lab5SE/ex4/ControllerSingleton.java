package week1.day2.lab5SE.ex4;

import week1.day2.lab5SE.ex3.LightSensor;
import week1.day2.lab5SE.ex3.TemperatureSensor;

import static java.lang.Thread.sleep;

public class ControllerSingleton {
    private static ControllerSingleton single_instance=null;
    private TemperatureSensor tempSensor;
    private LightSensor lightSensor;
    public void control(){
        lightSensor=new LightSensor();
        tempSensor=new TemperatureSensor();
        for(int i=1;i<=20;i++){
            System.out.println("Seconds passed: "+i);
            System.out.println("Light sensor: "+lightSensor.readValue());
            System.out.println("Temperature sensor: "+tempSensor.readValue()+"\n");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static ControllerSingleton getInstance(){
        if(single_instance==null)
            single_instance=new ControllerSingleton();
        return single_instance;
    }
    public static void main(String[] args){
        ControllerSingleton controller=ControllerSingleton.getInstance();
        controller.control();
    }

}

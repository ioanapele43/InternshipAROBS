package week1.day2.lab5SE.ex3;

import static java.lang.Thread.sleep;

public class Controller {
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
    public static void main(String[] args){
        Controller myController=new Controller();
        myController.control();
    }
}

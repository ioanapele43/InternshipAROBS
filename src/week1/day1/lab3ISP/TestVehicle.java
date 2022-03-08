package week1.day1.lab3ISP;

public class TestVehicle {
    static int numberOfVehicles;
    static int displayNumberOfVehicles(){
       return numberOfVehicles;
    }

    @Override
    public String toString() {
        return "number of vehicles"+displayNumberOfVehicles();
    }

    public static void main(String[] args){
        Vehicle vehicle1=new Vehicle("Dacia","Logan",300,'D');
        numberOfVehicles++;
        Vehicle vehicle2=new Vehicle("Reno","Modus",200,'B');
        numberOfVehicles++;
        System.out.println(vehicle1.toString());
        System.out.println(vehicle2.getModel()+"("+vehicle2.getType()+") speed "+vehicle2.getSpeed()+" fuel type "+vehicle2.getFuelType());
        vehicle2.setModel("Dacia");
        vehicle2.setType("Logan");
        vehicle2.setSpeed(300);
        vehicle2.setFuelType('D');
        System.out.println(vehicle2.toString());
        if(vehicle1.equals(vehicle2)){
            System.out.println("Are equals");
        }
        else{
            System.out.println("Are not equals");
        }
        vehicle2=vehicle1;
        if(vehicle1.equals(vehicle2)){
            System.out.println("Are equals");
        }
        else{
            System.out.println("Are not equals");
        }
        System.out.println("number of vehicles = "+displayNumberOfVehicles());
    }
}

package week1.day3.lab7.ex1;

public class NumberOfCofeeException extends Exception{
    int numberOfCofee;
    public NumberOfCofeeException(int numberOfCofee, String msg){
        super(msg);
        this.numberOfCofee=numberOfCofee;
    }
    int getNumberOfCofee(){return numberOfCofee;}
}

package week1.day3.lab7.ex1;

public class Cofee {
    private int temp;
    private int conc;
    private int number;

    Cofee(int t,int c, int n){temp = t;conc = c;number=n;}
    int getTemp(){return temp;}
    int getConc(){return conc;}
    int getNumber(){return number;}
    public String toString(){return "[cofee temperature="+temp+":concentration="+conc+"]";}

}

package week1.day1.lab2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args){
        Random rand=new Random();
        int secretNumber= rand.nextInt(101);//between 0 and 100
        Scanner in=new Scanner(System.in);
        System.out.print(" number=");
        int number=in.nextInt();
        ArrayList list=new ArrayList<Integer>();
        while(number!=secretNumber){
            if (!list.contains(number)){
                list.add(number);
            }
           System.out.println("\nAttemps="+list.size());
            if(number<secretNumber){
                System.out.println("too small");
            }
            else{
                System.out.println("too large");
            }
            System.out.print("\nnumber=");
            number=in.nextInt();
        }
        System.out.println("\nYou guessed the number");
        System.out.println("Attemps"+list.size());
    }
}

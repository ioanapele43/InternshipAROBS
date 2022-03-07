package week1.day1.lab2;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        Random rand=new Random();
        int n=rand.nextInt(9)+2;// rand.next(max-min+1)+min
        System.out.println("n= "+n);
        int myArray[];
        myArray=new int[n];
        System.out.println("Input "+n+ " elements");
        Scanner in=new Scanner(System.in);
        for(int i=0;i<n;i++){
            myArray[i]=in.nextInt();
        }
        System.out.println("Array: ");
        for(int i=0;i<n;i++) {
            System.out.print(myArray[i]+" ");
        }
        System.out.println();
        int sum=0;
        for(int i=0;i<n;i++) {
            sum=sum+myArray[i];
        }
        float mean=sum/n;
        System.out.println("Mean "+mean);


    }
}

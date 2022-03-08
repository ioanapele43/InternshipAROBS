package week1.day1.lab2ISP;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        System.out.println("Input all the words:");
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        String[] words=input.split(",",0);
        System.out.println("Starting letter:");
        String startL=in.nextLine();
        System.out.println("All the words:");
        for (String s:words) {
            if(s.startsWith(startL)) {
                System.out.println(s);
            }
        }


    }
}

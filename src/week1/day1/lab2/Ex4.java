package week1.day1.lab2;

import java.util.Scanner;

public class Ex4 {
    static boolean isPrime(int n){
        if(n<=1)
            return false;
        else if (n==2)
            return true;
        else if(n%2==0)
            return false;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;

    }
    static int firstPrime(int n,int[] array){
        for(int i=0;i<n;i++){
            if(isPrime(array[i])){
                return array[i];
            }
        }
        return -1;
    }
    static int firstOdd(int n,int[] array){
        for(int i=0;i<n;i++){
            if(array[i]%2==0){
                return array[i];
            }
        }
        return -1;
    }
    static int firstEven(int n,int[] array){
        for(int i=0;i<n;i++){
            if(array[i]%2==1){
                return array[i];
            }
        }
        return -1;
    }
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.println("n=");
        int n=in.nextInt();
        int[] array=new int[n];
        System.out.println(" elements: ");
        for(int i=0;i<n;i++){
            array[i]=in.nextInt();
        }
        int firstPrime=firstPrime(n,array);
        int firstOdd=firstOdd(n,array);
        int firstEven=firstEven(n,array);
        System.out.println("First Prime: ");
        if (firstPrime==-1)
            System.out.println("doesn't exist");
        else
            System.out.println(firstPrime);

        System.out.println("First Odd: ");
        if (firstOdd==-1)
            System.out.println("doesn't exist");
        else
            System.out.println(firstOdd);

        System.out.println("First Even: ");
        if (firstEven==-1)
            System.out.println("doesn't exist");
        else
            System.out.println(firstEven);
    }

}

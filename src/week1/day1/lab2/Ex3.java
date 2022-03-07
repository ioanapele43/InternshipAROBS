package week1.day1.lab2;

import java.util.Scanner;

public class Ex3 {
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
    static int summ(int n){
        int x=n;
        int sum=0;
        while(x>9){
            sum+=x%10;
            x=x/10;
        }
        sum+=x;
        return sum;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        for(int n=a;n<=b;n++){
            if (isPrime(n))
                System.out.print(n+" ");

        }
        System.out.println();
        System.out.println("n=");

        int n=in.nextInt();
        int[] arrayPrimes=new int[n];
        System.out.println("Prime numbers:");
        for(int i=0;i<n;i++){
            int nr=in.nextInt();
            arrayPrimes[i]=nr;
        }
        for(int i=0;i<n;i++){
            if(isPrime(summ(arrayPrimes[i])))
                System.out.print(arrayPrimes[i]+" ");
        }

    }
}

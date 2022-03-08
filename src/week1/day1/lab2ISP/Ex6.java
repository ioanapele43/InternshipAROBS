package week1.day1.lab2ISP;

import java.util.Scanner;

public class Ex6 {
    static long[] multiplyNR(int n){
        long[] array=new long[n];
        array[0]=1;
        array[1]=2;
        for(int i=2;i<n;i++){
            array[i]=array[i-1]*array[i-2];
        }
        return array;
    }
    static long[] multiplyR(int n, int poz,long[] array){
         if(poz==0){
            array[poz]=1;
            multiplyR(n,poz+1,array);
        }
        else if(poz==1){
            array[poz]=2;
            multiplyR(n,poz+1,array);
        }
        else if(poz<n){
            array[poz]=array[poz-1]*array[poz-2];
            multiplyR(n,poz+1,array);
        }
        return array;
    }
    public static void main(String[] args){
        System.out.print("n=");
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        System.out.println("Non-recursively");
        long[] array1=multiplyNR(n);
        for(int i=0;i<n;i++){
            System.out.print(array1[i]+" ");
        }
        System.out.println("\nRecursively");
        long[] array2=new long[n];
        array2=multiplyR(n,0,array2);
        for(int i=0;i<n;i++){
            System.out.print(array2[i]+" ");
        }
    }
}

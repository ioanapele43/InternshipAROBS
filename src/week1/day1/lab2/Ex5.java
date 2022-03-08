package week1.day1.lab2;

import java.util.Random;

public class Ex5 {
    public static void main(String[] args){
        Random rand=new Random();
        int[] vector=new int[20];
        for(int i=0;i<20;i++){
            vector[i]=rand.nextInt(2001)-1000;
        }
        System.out.println(" initial vector:");
        for(int i=0;i<20;i++){
            System.out.print(vector[i]+" ");
        }
        //bubbleSort
        int ok;
        do{
            ok=1;
            for(int i=0;i<19;i++){
                for(int j=i+1;j<20;j++){
                    if(vector[i]>vector[j]){
                        int aux=vector[i];
                        vector[i]=vector[j];
                        vector[j]=aux;
                        ok=0;
                    }
                }
            }
        }while(ok==0);
        System.out.println("\nSorted vector");
        for(int i=0;i<20;i++){
            System.out.print(vector[i]+" ");
        }
    }
}

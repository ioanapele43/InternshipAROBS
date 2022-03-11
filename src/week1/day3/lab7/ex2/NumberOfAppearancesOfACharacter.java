package week1.day3.lab7.ex2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NumberOfAppearancesOfACharacter {
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    public static void main(String[] args) throws Exception {
        String data = readFileAsString("C:\\Users\\carmen.pele\\Desktop\\Work\\src\\week1\\day3\\lab7\\ex2\\data.txt");
        System.out.print("the character wanted:");
        Scanner in=new Scanner(System.in);
        String c=in.next();
        char character=c.charAt(0);
        int numberOfCharacters=0;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)==character){
                numberOfCharacters++;
            }
        }
        System.out.println("The character "+character+" appears "+numberOfCharacters+" times");
    }
}

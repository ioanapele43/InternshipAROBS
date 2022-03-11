package week1.day3.lab7.ex3;

import java.io.FileWriter;
import java.util.Scanner;

import static week1.day3.lab7.ex2.NumberOfAppearancesOfACharacter.readFileAsString;

public class EncryptingDecrypting {
    public static void encrypt(String fileName) throws Exception {
        String data = readFileAsString(fileName);
        FileWriter myWriter=new FileWriter("src\\week1\\day3\\lab7\\ex3\\data.enc");
        for(int i=0;i<data.length();i++){
            char c=(char)(data.charAt(i)*2);
            myWriter.write(c);
        }
        myWriter.close();
    }
    public static void decrypt(String fileName) throws Exception {
        String data = readFileAsString(fileName);
        FileWriter myWriter=new FileWriter("src\\week1\\day3\\lab7\\ex3\\data.dec");
        for(int i=0;i<data.length();i++){
            char c=(char)(data.charAt(i)/2);
            myWriter.write(c);
        }
        myWriter.close();

    }
    public static void main(String[] args) throws Exception {
        String fileName ="";
        int operation=0;
        Scanner in=new Scanner(System.in);
        while(operation!=4){
            System.out.println("1- input filename ");
            System.out.println("2- encrypt file");
            System.out.println("3- dencrypt file");

            operation=in.nextInt();
            switch (operation){
                case 1:
                    in.nextLine();
                    fileName=in.nextLine();
                    System.out.println("FIlename : "+fileName);
                    break;
                case 2:
                    encrypt(fileName);
                    System.out.println("FIle encrypted with succes!");
                    break;
                case 3:
                    decrypt(fileName);
                    System.out.println("FIle dencrypted with succes!");
                    break;
                default:
            }
        }
        // encrypt("C:\\Users\\carmen.pele\\Desktop\\Work\\src\\week1\\day3\\lab7\\ex3\\data.txt");
        // decrypt("C:\\Users\\carmen.pele\\Desktop\\Work\\src\\week1\\day3\\lab7\\ex3\\data.enc");
    }
}

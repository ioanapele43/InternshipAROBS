package week1.day3.lab6.ex4;

import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Dictionary dictionary=new Dictionary();
        int command=0;
        String word;
        String definition;
        while(command!=5){
            System.out.println("\n1-add new word and its definition in the dictionary");
            System.out.println("2-get definition of a word");
            System.out.println("3-get all words");
            System.out.println("4-get all definitions");
            System.out.println("5-exit");
            command=in.nextInt();
            switch (command){
                case 1:
                    System.out.print("\n word=");
                    in.nextLine();
                    word=in.nextLine();

                    System.out.print("\n definition=");
                    definition=in.nextLine();
                    dictionary.addWord(new Word(word), new Definition(definition));
                    break;
                case 2:
                    System.out.print("\n word=");
                    in.nextLine();
                    word=in.nextLine();
                    Word w=new Word(word);
                    System.out.println("="+dictionary.getDefinition(w).getDescription());
                    break;
                case 3:
                    dictionary.getAllWords();
                    break;
                case 4:
                    dictionary.getAllDefinitions();
                    break;
                default:
            }
        }
    }
}

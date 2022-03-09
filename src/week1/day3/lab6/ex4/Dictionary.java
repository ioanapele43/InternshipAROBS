package week1.day3.lab6.ex4;

import java.util.*;

public class Dictionary {
    private HashMap<Word,Definition> dictionary;
    public Dictionary(){
        dictionary=new HashMap<Word,Definition>();
    }
    public void addWord(Word w,Definition d){
        dictionary.put(w,d);
    }
    public Definition getDefinition(Word w){
        Definition def=new Definition("not found");
        for(Map.Entry<Word,Definition> entry:dictionary.entrySet()){
            if(entry.getKey().getName().equals(w.getName())){
                def=entry.getValue();
            }
        }
        return def;
    }
    public void getAllWords(){
        Set<Word> words=dictionary.keySet();
        System.out.print("\nWORDS:");
        for(Word w:words){
            System.out.print(w.getName()+",");
        }
    }
    public void getAllDefinitions(){
        Collection<Definition> definitions=dictionary.values();
        System.out.print("\nDEFINITIONS:");
        for(Definition d:definitions){
            System.out.print(d.getDescription()+",");
        }

    }
}

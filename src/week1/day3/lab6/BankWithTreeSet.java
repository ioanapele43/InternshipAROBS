package week1.day3.lab6;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class BankWithTreeSet {
    private TreeSet<BankAccount> accounts;
    public BankWithTreeSet(){
        accounts=new TreeSet<BankAccount>();
    }
    public void addAccount(String owner, double balance){
        accounts.add(new BankAccount(owner,balance));
    }

    public void printAccounts(){
        System.out.println("\nSorted by balance");
        TreeSet<BankAccount> set= new TreeSet<BankAccount>(new SortByBalance());
        for(BankAccount b:accounts){
            set.add(b);
        }
        for(BankAccount b:set){
            System.out.println("("+b.getOwner()+","+b.getBalance()+")");
        }
    }
    public void printAccounts(double minBalance, double maxBalance){
        for(BankAccount b:accounts){
            if(b.getBalance()>=minBalance && b.getBalance()<=maxBalance)
                System.out.println("("+b.getOwner()+","+b.getBalance()+")");
        }
    }
    public BankAccount getAccount(String owner){
        BankAccount myAccount=null;
        for(BankAccount b:accounts){
            if(b.equals(myAccount)) // verify if the accounts have the same owner
                myAccount=b;
        }
        return myAccount;
    }
    public void getAllAccounts(){
        TreeSet<BankAccount> set= new TreeSet<BankAccount>(new SortByName());
        for(BankAccount b:accounts){
            set.add(b);
        }
        for(BankAccount b:set){
            System.out.println("("+b.getOwner()+","+b.getBalance()+")");
        }
    }
}

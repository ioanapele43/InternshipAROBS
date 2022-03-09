package week1.day3.lab6;

import java.util.ArrayList;
import java.util.Collections;

public class Bank {
    private ArrayList<BankAccount> accounts;
    public Bank(){
        accounts=new ArrayList<BankAccount>();
    }
    public void addAccount(String owner, double balance){
        BankAccount b=new BankAccount(owner,balance);
        boolean exist=false;


        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).equals(b)){
                balance+=accounts.get(i).getBalance();
                b.setBalance(balance);
                accounts.set(i,b);
                exist=true;
            }
        }
        if(exist==false){
            accounts.add(b);
        }


    }

    public void printAccounts(){
        System.out.println("\nSorted by balance");
        Collections.sort(accounts,new SortByBalance());
        for(BankAccount b:accounts){
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
        Collections.sort(accounts,new SortByName());
        for(BankAccount b:accounts){
            System.out.println("("+b.getOwner()+","+b.getBalance()+")");
        }
    }


}

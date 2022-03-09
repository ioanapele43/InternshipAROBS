package week1.day3.lab6;

import java.util.Comparator;

public class BankAccount implements Comparable<BankAccount> {
    private String owner;
    private double balance;
    public BankAccount(String owner, double balance){
        this.owner=owner;
        this.balance=balance;
    }
    public BankAccount(String owner){
        this.owner=owner;
        this.balance=0;
    }
    public void withdraw(double amount){
        this.balance-=amount;
    }
    public void deposit(double amount){
        this.balance+=amount;
    }



    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null || o.getClass()!=this.getClass()){
            return false;
        }

        BankAccount ba=(BankAccount) o;
        return (this.owner.equals(ba.owner) );
    }
    @Override
    public int hashCode(){
        return this.hashCode();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int compareTo(BankAccount o) {
        return this.getOwner().compareTo(o.getOwner());
    }
}

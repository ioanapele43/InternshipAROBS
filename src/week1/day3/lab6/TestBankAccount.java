package week1.day3.lab6;

public class TestBankAccount {
    public static void main(String[] args){
        BankAccount bankAccount1=new BankAccount("Kevin",2000.0);
        BankAccount bankAccount2=new BankAccount("Tom",1000.0);
        BankAccount bankAccount3=new BankAccount("Kevin",2000.0);
        System.out.println("("+bankAccount1.getOwner()+","+bankAccount1.getBalance()+") = ("+bankAccount2.getOwner()+","+bankAccount2.getBalance()+") is "+(bankAccount1.equals(bankAccount2)));
        System.out.println("("+bankAccount1.getOwner()+","+bankAccount1.getBalance()+") = ("+bankAccount3.getOwner()+","+bankAccount3.getBalance()+") is "+(bankAccount1.equals(bankAccount3)));
    }
}

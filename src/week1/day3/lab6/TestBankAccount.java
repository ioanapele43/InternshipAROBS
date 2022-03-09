package week1.day3.lab6;

public class TestBankAccount {
    public static void main(String[] args){
        BankAccount bankAccount1=new BankAccount("Kevin",2000.0);
        BankAccount bankAccount2=new BankAccount("Tom",1000.0);
        BankAccount bankAccount3=new BankAccount("Kevin",3000.0);
        System.out.println("("+bankAccount1.getOwner()+","+bankAccount1.getBalance()+") = ("+bankAccount2.getOwner()+","+bankAccount2.getBalance()+") is "+(bankAccount1.equals(bankAccount2)));
        System.out.println("("+bankAccount1.getOwner()+","+bankAccount1.getBalance()+") = ("+bankAccount3.getOwner()+","+bankAccount3.getBalance()+") is "+(bankAccount1.equals(bankAccount3)));
        Bank bank=new Bank();
        bank.addAccount(bankAccount1.getOwner(),bankAccount1.getBalance());
        bank.addAccount(bankAccount2.getOwner(),bankAccount2.getBalance());
        bank.addAccount(bankAccount3.getOwner(),bankAccount3.getBalance());
        bank.printAccounts();
        System.out.println("\nSorted list by owners");
        bank.getAllAccounts();

        System.out.println("Bank implemented with TreeSet");
        BankWithTreeSet bankt=new BankWithTreeSet();
        bankt.addAccount(bankAccount1.getOwner(),bankAccount1.getBalance());
        bankt.addAccount(bankAccount2.getOwner(),bankAccount2.getBalance());
        bankt.addAccount(bankAccount3.getOwner(),bankAccount3.getBalance());
        bankt.printAccounts();
        System.out.println("\nSorted list by owners");
        bankt.getAllAccounts();
    }
}

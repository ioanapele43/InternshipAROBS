package week1.day3.lab6;

import java.util.Comparator;

public class SortByBalance implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return (int)(o1.getBalance()-o2.getBalance());
    }
}

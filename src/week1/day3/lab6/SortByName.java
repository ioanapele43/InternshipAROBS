package week1.day3.lab6;

import java.util.Comparator;

public class SortByName implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getOwner().compareTo(o2.getOwner());
    }
}

package week1.day2.lab4SE;

import week1.day2.lab4SE.Author;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock=0;
    public Book(String name, Author author, double price){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qtyInStock=0;
    }
    public Book(String name, Author author, double price, int qtyInStock){
        this.name=name;
        this.author=author;
        this.price=price;
        this.qtyInStock=qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
}

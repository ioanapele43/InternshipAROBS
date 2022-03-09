package week1.day2.lab4SE;

import week1.day2.lab4SE.Author;

public class BookMultipleAuthors {
    private String name;
    private Author[] authors;
    private double price;
    private int qtyInStock=0;
    public BookMultipleAuthors(String name, Author[] authors, double price){
        this.name=name;
        this.authors=authors;
        this.price=price;
        this.qtyInStock=0;
    }
    public BookMultipleAuthors(String name, Author[] authors, double price, int qtyInStock){
        this.name=name;
        this.authors=authors;
        this.price=price;
        this.qtyInStock=qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
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

    @Override
    public String toString() {
        return "book-"+name+" by "+authors.length+" authors";
    }
    public void printAuthors(){
        System.out.println("Authors: ");
        for(Author a:authors){
            System.out.println(a.toString());
        }
    }
}

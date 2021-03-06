package week1.day1.lab3ISP;

import java.util.ArrayList;
import java.util.List;

public class NewVendingMachine {
    private static NewVendingMachine single_instance=null;
    private int credit;
    private int rest=0;
    private List<Product> products;
    public NewVendingMachine(){
        credit=0;
        products=new ArrayList<Product>();
    }
    public static NewVendingMachine getInstance(){
        if(single_instance==null)
            single_instance=new NewVendingMachine();
        return single_instance;
    }
    public void displayProducts(){
        for (Product p:products) {
            System.out.print(p.getName()+" ");
        }
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public void insertCoin(int value){
        this.credit-=value;
    }
    public String selectProduct(int id){
        String productName="";
        for(Product p:products){
            if(p.getId()==id){
                productName=p.getName();
            }
        }
        return productName;
    }
    public int selectProductQuantity(int id){
        int prodQ=0;
        for(Product p:products){
            if(p.getId()==id){
                prodQ=p.getQuantity();
            }
        }
        return prodQ;
    }
    public void displayCredit(int id, int q){
        int credit=0;
        for(Product p:products){
            if(p.getId()==id){
                credit=p.decreaseProduct(q);
            }
        }
        //System.out.println(credit);
        this.credit+=credit;
    }
    public void userMenu(){
        System.out.println("\n1-select product id");
        System.out.println("2-select quantity");
        System.out.println("3-display credit");
        System.out.println("4-insert coint");
        System.out.println(("5- exit"));
    }
    public void returnRest(){
        if(this.credit<0){
            rest=Math.abs(credit);
            this.credit=0;
        }
        else{
            rest=0;
        }
    }
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }
}

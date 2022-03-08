package week1.day1.lab3;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    public Product(){
        this.id=0;
        this.name="";
        this.price=0;
        this.quantity=0;
    }
    public Product(int id,String name, int price,int q){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=q;
    }
    public int decreaseProduct(int quantityDecreased){
        this.quantity-=quantityDecreased;
        return quantityDecreased*price;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

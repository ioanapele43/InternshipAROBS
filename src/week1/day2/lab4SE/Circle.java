package week1.day2.lab4SE;

public class Circle {
    private double radius;
    private String color;
    public Circle(){
        radius=1.0;
        color="red";
    }
    public Circle(double radius){
        this.radius=radius;
        this.color="red";
    }
    public double getRadius(){
        return this.radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public static void main(String[] args){
        Circle c=new Circle(3);
        System.out.println("Radius "+c.getRadius());
        System.out.println("Area "+c.getArea());

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

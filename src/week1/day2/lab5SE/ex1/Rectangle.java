package week1.day2.lab5SE.ex1;

public class Rectangle extends Shape{
    protected double width;
    protected double length;
    public Rectangle(){
        this.width=1.0;
        this.length=1.0;
    }
    public Rectangle(double width, double length){
        this.width=width;
        this.length=length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
        this.width=width;
        this.length=length;
        super.setColor(color);
        super.setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public double getPerimeter() {
        return 2*width+2*length;
    }

    @Override
    public String toString() {
        return "A Rectangle with width="+width+" and length="+length+", which is a subclass of Shape";
    }
}

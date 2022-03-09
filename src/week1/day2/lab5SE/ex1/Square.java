package week1.day2.lab5SE.ex1;

public class Square extends Rectangle{
    public Square(){
        super.setLength(1.0);
        super.setWidth(1.0);
    }
    public Square(double side){
        super.setLength(side);
        super.setWidth(side);
    }
    public Square(double side, String color, boolean filled){
        super.setLength(side);
        super.setWidth(side);
        super.setColor(color);
        super.setFilled(filled);
    }
    public double getSide(){
        return super.getLength();
    }
    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    public void setLength(double side){
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "A Square with side="+getSide()+", which is a subclass of "+super.toString();
    }
}

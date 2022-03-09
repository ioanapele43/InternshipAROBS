package week1.day2.lab4SE;

import week1.day2.lab4SE.Circle;

public class Cylinder extends Circle {
    private double height=1.0;
    public Cylinder(){
        height=1.0;
    }
    public Cylinder(Double radius){
        super.setRadius(radius);
    }
    public Cylinder(Double radius,double height){
        super.setRadius(radius);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume(){
        return Math.PI*super.getRadius()*super.getRadius()*this.height;
    }
    public static void main(String[] args){
        Cylinder c=new Cylinder(3.0,2.0);
        System.out.println("volume with heigth "+c.getHeight()+" and radius "+c.getRadius()+" is "+c.getVolume());
    }
}

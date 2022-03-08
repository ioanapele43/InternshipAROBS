package week1.day1.lab3;

public class TestMyPoint {
    public static void main(String[] args){
        MyPoint point1=new MyPoint(1,2,3);
        MyPoint point2=new MyPoint(3,4,5);
        System.out.println("Distance by coordonates: ("+point1.getX()+","+point1.getY()+","+point1.getZ()+") and (5,5,5)");
        System.out.println(point1.distance(5,5,5));
        System.out.println("Distance between 2 points:("+point1.getX()+","+point1.getY()+","+point1.getZ()+") and("+point2.getX()+","+point2.getY()+","+point2.getZ()+")");
        System.out.println(point1.distance(point2));
    }
}

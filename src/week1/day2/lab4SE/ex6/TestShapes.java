package week1.day2.lab4SE.ex6;

public class TestShapes {
    public static void main(String[] args){
        Shape shape=new Shape("red",true);
        Circle circle=new Circle(5,"pink",false);
        Rectangle rectangle=new Rectangle(2,3,"yellow",true);
        Square square=new Square(5,"black",true);

        System.out.println(shape.toString());
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}

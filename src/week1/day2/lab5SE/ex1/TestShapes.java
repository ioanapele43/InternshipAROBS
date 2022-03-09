package week1.day2.lab5SE.ex1;


public class TestShapes {
    public static void main(String[] args){
        Circle circle=new Circle(5,"pink",false);
        Rectangle rectangle=new Rectangle(2,3,"yellow",true);
        Square square=new Square(5,"black",true);

        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());
    }
}

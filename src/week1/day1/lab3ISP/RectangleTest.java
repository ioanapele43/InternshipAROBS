package week1.day1.lab3ISP;

public class RectangleTest {
    public static void main(String[] args){
        Rectangle myRectangle=new Rectangle();
        System.out.println("length="+myRectangle.getLength()+" width="+myRectangle.getWidth()+" color="+myRectangle.getColor());
        myRectangle= new Rectangle(3,4);
        System.out.println("length="+myRectangle.getLength()+" width="+myRectangle.getWidth()+" color="+myRectangle.getColor());
        myRectangle= new Rectangle(5,6,"pink");
        System.out.println("length="+myRectangle.getLength()+" width="+myRectangle.getWidth()+" color="+myRectangle.getColor());
        System.out.println("Perimeter="+myRectangle.getPerimeter());
        System.out.println("Area="+myRectangle.getArea());

    }
}

package week1.day1.lab3ISP;

public class Rectangle {
    private int length=2;
    private int width=1;
    private String color="red";
    public Rectangle(){
        length=2;
        width=1;
        color="red";
    }
    public Rectangle(int l, int w){
        length=l;
        width=w;
    }
    public Rectangle(int l, int w,String c){
        length=l;
        width=w;
        color=c;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }
    public int getPerimeter(){
        return 2*length+2*width;
    }
    public int getArea(){
        return length*width;
    }
}

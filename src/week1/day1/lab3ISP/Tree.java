package week1.day1.lab3ISP;

public class Tree {
    private int height;
    public Tree(){
        height=15;
    }
    public void grow(int meters){
        if(meters>=1){
            height+=meters;
        }
    }

    @Override
    public String toString() {
        return  "height=" + height;
    }
}

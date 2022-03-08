package week1.day1.lab3ISP;

public class MyPoint {
    private int x;
    private int y;
    private int z;
    public MyPoint(){
        x=0;
        y=0;
        z=0;
    }
    public MyPoint(int x,int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public void setXYZ(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
    public double distance(int x,int y, int z){
        return Math.sqrt(((this.x - x)*(this.x - x) + (this.y-y)*(this.y-y) +(this.z-z)*(this.z-z)) );
    }
    public double distance(MyPoint another){
        return Math.sqrt(((this.x - another.getX())*(this.x - another.getX()) + (this.y-another.getY())*(this.y-another.getY()) +(this.z-another.getZ())*(this.z-another.getZ())) );
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

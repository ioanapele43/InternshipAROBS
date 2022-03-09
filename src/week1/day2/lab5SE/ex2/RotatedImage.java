package week1.day2.lab5SE.ex2;

public class RotatedImage implements Image{
    private String fileName;
    public RotatedImage(String fileName){
        this.fileName=fileName;
        loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("RodatedImage "+fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

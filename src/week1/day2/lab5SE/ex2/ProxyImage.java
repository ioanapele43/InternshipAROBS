package week1.day2.lab5SE.ex2;

public class ProxyImage implements Image{

    private RealImage realImage;
    private RotatedImage rotatedImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }
    public ProxyImage(RealImage realImage){
        this.realImage=realImage;
    }
    public ProxyImage(RotatedImage rotatedImage){
        this.rotatedImage=rotatedImage;
    }

    @Override
    public void display() {
        if(realImage != null){
            realImage.display();
        }
        else if (rotatedImage!=null){
            realImage.display();
        }
        else{
            realImage=new RealImage(fileName);
            rotatedImage=new RotatedImage(fileName);
        }

    }
}

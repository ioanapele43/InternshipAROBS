package week1.day4.lab10.ex4;

public class RobotsGame implements Runnable {
    private Robot robot1;
    private Robot robot2;
    private Robot robot3;
    private Robot robot4;
    private Robot robot5;
    private Robot robot6;
    private Robot robot7;
    private Robot robot8;
    private Robot robot9;
    private Robot robot10;
    public RobotsGame(){
        robot1=new Robot(0,0);
        robot2=new Robot(10,0);
        robot3=new Robot(20,0);
        robot4=new Robot(30,0);
        robot5=new Robot(40,0);
        robot6=new Robot(50,0);
        robot7=new Robot(60,0);
        robot8=new Robot(70,0);
        robot9=new Robot(80,0);
        robot10=new Robot(99,0);
    }
    @Override
    public void run() {

    }
    public static void main(String[] args){
        RobotsGame robotsGame=new RobotsGame();
        robotsGame.robot1.run();
    }
}

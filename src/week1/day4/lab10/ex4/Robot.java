package week1.day4.lab10.ex4;

import java.awt.print.Printable;
import java.util.Random;

public class Robot extends Thread{
    private int currentPositionX;
    private int currentPositionY;
    private boolean destroyed;
    public Robot(int currentPositionX, int currentPositionY){
        this.currentPositionX=currentPositionX;
        this.currentPositionY=currentPositionY;
        this.destroyed=false;
    }
    public static boolean checkPositionInSpace(int i,int j){
        if(i<0 || i>99 || j<0 || j>99)
            return false;
        else
            return true;

    }
    public void run(){
        Random rand=new Random();
        int nextX=this.currentPositionX;
        int nextY=this.currentPositionY;
        do{
            nextX=this.currentPositionX;
            nextY=this.currentPositionY;
            int nextMove=rand.nextInt(4)+1; // 1-sus 2-dreapta 3-jos 4 -stanga
            switch (nextMove){
                case 1:
                    nextX--;
                    break;
                case 2:
                    nextY++;
                    break;
                case 3:
                    nextX--;
                    break;
                case 4:
                    nextY--;
                    break;
                default:
            }
        }while(!checkPositionInSpace(nextX,nextY));
        System.out.println("Thread "+Thread.currentThread().getName()+" move "+nextX+","+nextY);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getCurrentPositionX() {
        return currentPositionX;
    }

    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    public int getCurrentPositionY() {
        return currentPositionY;
    }

    public void setCurrentPositionY(int currentPositionY) {
        this.currentPositionY = currentPositionY;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public static void main(String[] args) throws InterruptedException {
        Robot robot1=new Robot(0,0);
        Robot robot2=new Robot(10,0);
        Robot robot3=new Robot(20,0);
        Robot robot4=new Robot(30,0);
        Robot robot5=new Robot(40,0);
        Robot robot6=new Robot(50,0);
        Robot robot7=new Robot(60,0);
        Robot robot8=new Robot(70,0);
        Robot robot9=new Robot(80,0);
        Robot robot10=new Robot(99,0);
        robot1.start();
        //robot1.join();
        robot2.start();
       // robot2.join();
        robot3.start();
        //robot3.join();
        robot4.start();
        //robot4.join();
        robot5.start();
       // robot5.join();
        robot6.start();
       // robot6.join();
        robot7.start();
        //robot7.join();
        robot8.start();
       // robot8.join();
        robot9.start();
        //robot9.join();
        robot10.start();
       // robot10.join();
    }
}

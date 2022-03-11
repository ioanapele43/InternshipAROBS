package week1.day4.lab10.ex4;

import java.util.ArrayList;
import java.util.List;

public class RobotsGame implements Runnable {
    private List<Robot> robotList=new ArrayList<Robot>();
    private int[][] space;
    public RobotsGame(){
        space=new int[100][100];
        robotList.add(new Robot(1,0,0));
        robotList.add(new Robot(2,1,0));
        robotList.add(new Robot(3,2,0));
        robotList.add(new Robot(4,3,0));
        robotList.add(new Robot(5,4,0));
        robotList.add(new Robot(6,5,0));
        robotList.add(new Robot(7,6,0));
        robotList.add(new Robot(8,7,0));
        robotList.add(new Robot(9,8,0));
        robotList.add(new Robot(10,9,0));

    }
    @Override
    public void run() {
        robotList.stream().forEach((robot)->{
            space[robot.getCurrentPositionX()][robot.getCurrentPositionY()]++;
            if(!robot.isDestroyed()){
                robot.run();
            }

        });
        for(int x=0;x<100;x++){
            for(int y=0;y<100;y++){
                if(space[x][y]>1){
                    for(Robot r: robotList){
                        if(r.getCurrentPositionX()==x && r.getCurrentPositionY()==y){
                            r.setDestroyed(true);
                        }
                    }
                }
                space[x][y]=0;
            }
        }
        System.out.println();


    }

    public static void main(String[] args){
        RobotsGame robotsGame=new RobotsGame();
        for(int i=0;i<30;i++) {
            robotsGame.run();
        }
        robotsGame.getRobotList().stream().forEach((robot)->{
            if(robot.isDestroyed()) {
                System.out.println("Robot " + robot.getIdR() + " was destroyed");
             }
            });
    }
    public List<Robot> getRobotList() {
        return robotList;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }

    public int[][] getSpace() {
        return space;
    }

    public void setSpace(int[][] space) {
        this.space = space;
    }
}



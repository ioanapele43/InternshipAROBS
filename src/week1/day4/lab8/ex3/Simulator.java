package week1.day4.lab8.ex3;

import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {

        //build station Cluj-Napoca
        Controler c1 = new Controler("Cluj-Napoca");

        Segment s1 = new Segment(1);
        Segment s2 = new Segment(2);
        Segment s3 = new Segment(3);

        c1.addControlledSegment(s1);
        c1.addControlledSegment(s2);
        c1.addControlledSegment(s3);

        //build station Bucuresti
        Controler c2 = new Controler("Bucuresti");

        Segment s4 = new Segment(4);
        Segment s5 = new Segment(5);
        Segment s6 = new Segment(6);

        c2.addControlledSegment(s4);
        c2.addControlledSegment(s5);
        c2.addControlledSegment(s6);

        //build station Bistrita
        Controler c3=new Controler("Bistrita");

        Segment s7=new Segment(7);
        Segment s8=new Segment(8);
        Segment s9=new Segment(9);

        c3.addControlledSegment(s7);
        c3.addControlledSegment(s8);
        c3.addControlledSegment(s9);

        //connect the 3 controllers

        c1.addNeighbourController(c2);
        c1.addNeighbourController(c3);
        c2.addNeighbourController(c1);
        c2.addNeighbourController(c3);
        c3.addNeighbourController(c1);
        c3.addNeighbourController(c2);

        //testing

        Train t1 = new Train("Bucuresti", "IC-001");
        s1.arriveTrain(t1);

        Train t2 = new Train("Cluj-Napoca","R-002");
        s5.arriveTrain(t2);

        Train t3 = new Train("Bistrita","R-003");
        s7.arriveTrain(t3);


        c1.displayStationState();
        c2.displayStationState();
        c3.displayStationState();

        System.out.println("\nStart train control\n");

        //execute 3 times controller steps
        for(int i = 0;i<3;i++){
            System.out.println("### Step "+i+" ###");
            c1.controlStep();
            c2.controlStep();

            System.out.println();

            c1.displayStationState();
            c2.displayStationState();
            c3.displayStationState();
        }
    }
}

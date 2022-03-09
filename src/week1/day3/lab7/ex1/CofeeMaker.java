package week1.day3.lab7.ex1;

public class CofeeMaker {
    Cofee makeCofee(int n){
        System.out.println("Make a coffe");
        int t = (int)(Math.random()*100);
        int c = (int)(Math.random()*100);

        Cofee cofee = new Cofee(t,c,n);
        return cofee;
    }
}

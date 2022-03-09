package week1.day3.lab7.ex1;

import java.util.Scanner;

public class CofeeTest {
    public static void main(String[] args) {
        CofeeMaker mk = new CofeeMaker();
        CofeeDrinker d = new CofeeDrinker();
        System.out.print("n=");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i = 0;i<n;i++){
            Cofee c = mk.makeCofee(i);
            try {
                d.drinkCofee(c);
            } catch (TemperatureException e) {
                System.out.println("Exception:"+e.getMessage()+" temp="+e.getTemp());
            } catch (ConcentrationException e) {
                System.out.println("Exception:"+e.getMessage()+" conc="+e.getConc());
            } catch (NumberOfCofeeException e) {
                System.out.println("Exception:"+e.getMessage()+" number of coffes="+e.getNumberOfCofee());
            } finally{
                System.out.println("Throw the cofee cup.\n");
            }
        }
    }
}

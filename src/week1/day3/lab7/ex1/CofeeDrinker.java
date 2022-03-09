package week1.day3.lab7.ex1;

public class CofeeDrinker {
    void drinkCofee(Cofee c) throws TemperatureException, ConcentrationException, NumberOfCofeeException {
        if(c.getTemp()>60)
            throw new TemperatureException(c.getTemp(),"Cofee is to hot!");
        if(c.getConc()>50)
            throw new ConcentrationException(c.getConc(),"Cofee concentration to high!");
        if(c.getNumber()>20)
            throw new NumberOfCofeeException(c.getNumber(),"Too many coffes");
        System.out.println("Drink cofee:"+c);
    }
}

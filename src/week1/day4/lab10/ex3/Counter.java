package week1.day4.lab10.ex3;

public class Counter extends Thread{
    private int startValue;
    private int stopValue;
    public Counter(int startValue,int stopValue){
        this.startValue=startValue;
        this.stopValue=stopValue;
    }
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName()+" is starting to count");
        for(int i=startValue;i<stopValue;i++){
            System.out.println("Thread "+Thread.currentThread().getName()+" count="+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+Thread.currentThread().getName()+" finished his counting");
    }
    public static void main(String[] args) throws InterruptedException {
        Counter counter1=new Counter(0,100);
        counter1.start();
        counter1.join();
        Counter counter2=new Counter(100,200);
        counter2.start();
    }
}

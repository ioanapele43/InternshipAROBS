package week1.day1.lab3ISP;

import java.util.Scanner;

public class TestNewVendingMachine {
    public static void main(String[] args){
        NewVendingMachine vm=NewVendingMachine.getInstance();
        Product prod1=new Product(1,"water",3,30);
        Product prod2=new Product(2,"juice",6,40);
        Product prod3=new Product(3,"sandwich",10,10);
        vm.addProduct(prod1);
        vm.addProduct(prod2);
        vm.addProduct(prod3);
        Scanner in=new Scanner(System.in);
        int idP=0;
        int qP=0;
        int coin=0;
        int command=0;
        while(command!=5){
            vm.userMenu();
            command=in.nextInt();
            switch (command){
                case 1:
                    System.out.print("\nid=");
                    idP=in.nextInt();
                    vm.selectProduct(idP);
                    break;
                case 2:
                    System.out.print("\nquantity=");
                    qP=in.nextInt();
                    if(vm.selectProductQuantity(idP)==0){
                        System.out.println("\nProduct no longer available");
                        break;
                    }
                    while(qP>vm.selectProductQuantity(idP)){
                        System.out.println("\nQuantity too large");
                        System.out.print("new quantity=");
                        qP=in.nextInt();
                    }
                    break;
                case 3:
                    vm.displayCredit(idP,qP);
                    System.out.print("\ncredit="+vm.getCredit());
                    break;
                case 4:
                    System.out.print("\ninput coins:");
                    coin=in.nextInt();
                    vm.insertCoin(coin);
                    vm.returnRest();
                    System.out.print("\ncredit="+vm.getCredit());
                    System.out.print("\nrest="+vm.getRest());
                    break;
                default:


            }

        }

    }
}

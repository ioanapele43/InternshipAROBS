package week1.day1.lab3ISP;

public class TreeTest {
    public static void main(String[] args){
        Tree myTree=new Tree();
        System.out.println(myTree.toString());
        myTree.grow(5);
        System.out.println(myTree.toString());
        myTree.grow(-3);
        System.out.println(myTree.toString());
    }
}

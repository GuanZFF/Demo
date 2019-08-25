package pers.zhenfeng.base;

/**
 * @author Grow-Worm
 * @date 2019/08/10
 */
public class Guan {

    public static void main(String[]args) {
        new Thread(() -> printHashCode("Guan1", new Guan()), "Guan1");
        new Thread(() -> printHashCode("Guan2", new Guan()), "Guan2");
    }

    public static void printHashCode(String name, Object obj) {
        System.out.println("--------------------------------------");
        System.out.println(name + " = " + obj.hashCode());
        System.out.println("--------------------------------------");
    }

}
package pers.zhenfeng.thread;

/**
 * @author Grow-Worm
 * @date 2019/04/15
 */
public class Test {

    private static Test test = new Test();

    {
        System.out.println("Test.instance initializer");
    }

    static {
        System.out.println("Test.static initializer");
    }

    public static void main(String[] args) {
        new Test();
    }
}

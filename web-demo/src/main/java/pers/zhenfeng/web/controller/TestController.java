package pers.zhenfeng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author Grow-Worm
 * @date 2020/06/05
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("monitor")
    @ResponseBody
    public void monitor() {

        Object lock = new Object();

        new Thread(() -> {

            synchronized (lock) {
                System.out.println("thread A");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {

            synchronized (lock) {
                System.out.println("thread B");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();
    }

    private boolean condition;

    @RequestMapping("deadCycle")
    @ResponseBody
    public String deadCycle() {
        double c = 1.0;

        while (condition) {
            double a = Math.random();
            double b = Math.random();
            c = a * b;
        }

        return "end" + c;
    }

    @RequestMapping("condition")
    @ResponseBody
    public String setCondition(Boolean condition) {
        this.condition = condition;
        return condition ? "true" : "false";
    }

    @RequestMapping("memory")
    @ResponseBody
    public String memoryOut() {
        byte[] b = new byte[1024 * 1024 * 10];


        return "";
    }

}

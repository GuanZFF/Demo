package pers.zhenfeng.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Grow-Worm
 * @date 2020/02/09
 */
public class CurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "GuanZhenFeng");

        map.put("password", "123456");

        System.out.println(map.get("name"));
    }

}

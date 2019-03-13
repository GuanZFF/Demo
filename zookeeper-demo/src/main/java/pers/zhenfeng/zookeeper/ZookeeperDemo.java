package pers.zhenfeng.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/02/26
 */
public class ZookeeperDemo {

    public static void main(String[] args) throws Exception {

        ZooKeeper zooKeeper = new ZooKeeper("140.143.201.74:2181", 3000, watchedEvent -> {
            System.out.println("ZookeeperDemo.process");
            System.out.println(watchedEvent.getPath());
        });


        List<String> children = zooKeeper.getChildren("/configs", event -> {
            System.out.println(event.getPath());
            System.out.println(event.getType().getIntValue());
            if (Watcher.Event.EventType.NodeCreated.equals(event.getType())) {
                System.out.println("ZookeeperDemo.main create");
            }
            if (Watcher.Event.EventType.NodeDataChanged.equals(event.getType())) {
                System.out.println("ZookeeperDemo.main changed");
            }
        });

        for (String key : children) {
            Stat stat = new Stat();

            byte[] data = zooKeeper.getData("/configs/" + key, event -> {
                System.out.println(event.getPath());
                System.out.println(event.getType().getIntValue());
                System.out.println("监听器触发");
            }, stat);

            System.out.println(key + " = " + new String(data));

        }

        zooKeeper.getData("/configs", event -> {
            System.out.println("getData()");
            System.out.println(event.getPath());
        }, new Stat());

        zooKeeper.register(event -> {
            System.out.println("111  " + event.getPath());
            if ((Watcher.Event.EventType.NodeCreated.equals(event.getType())
                    || Watcher.Event.EventType.NodeCreated.equals(event.getType()))
                    && event.getPath().startsWith("/configs")) {
                System.out.println("create or update" + event.getPath());
            }
            if (Watcher.Event.EventType.NodeDeleted.equals(event.getType())
                    && event.getPath().startsWith("/configs")) {
                System.out.println("delete" + event.getPath());
            }
        });

        System.in.read();
    }

}

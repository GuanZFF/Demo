package pers.zhenfeng.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ZooKeeperServer;

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


        Stat stat = new Stat();

        zooKeeper.getData("/data", event -> {
            System.out.println("监听器触发");
        }, stat);

        zooKeeper.getData("/data", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println("发生了回调");
            }
        }, null);

        System.in.read();
    }

}

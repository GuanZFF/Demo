package pers.zhenfeng.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author Grow-Worm
 * @date 2019/02/26
 */
public class CuratorClient {

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("140.143.201.74:2181", new RetryNTimes(3, 1000));

        client.start();

        String path = "/data";
        client.getData().usingWatcher((CuratorWatcher) event -> {
            System.out.println("调用watcher");
        }).forPath(path);

        System.in.read();
    }

}

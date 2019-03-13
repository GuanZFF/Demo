package pers.zhenfeng.zookeeper.app;

import com.google.common.collect.Maps;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Grow-Worm
 * @date 2019/03/10
 */
public class ZookeeperConfig {

    private static Map<String, String> cacheMap = Maps.newHashMap();

    private static String PARENT_NAME = "/configs";

    private static ZooKeeper zkClient;

    static {
        init();
    }

    private static void init() {
        try {
            zkClient = new ZooKeeper("140.143.201.74:2181", 3000, null);
            List<String> keys = zkClient.getChildren(PARENT_NAME, false);
            if (keys != null && keys.size() <= 0) {
                Stat stat = new Stat();
                for (String key : keys) {
                    byte[] data = zkClient.getData(PARENT_NAME + "/" + key, null, stat);
                    cacheMap.put(key, new String(data));
                }
            }

            zkClient.register(event -> {
                if ((Watcher.Event.EventType.NodeCreated.equals(event.getType())
                        || Watcher.Event.EventType.NodeCreated.equals(event.getType()))
                        && event.getPath().startsWith(PARENT_NAME)) {
                    System.out.println("create or update" + event.getPath());
                }
                if (Watcher.Event.EventType.NodeDeleted.equals(event.getType())
                        && event.getPath().startsWith(PARENT_NAME)) {
                    System.out.println("delete" + event.getPath());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(String key, String value) {
        try {
            cacheMap.put(key, value);
            zkClient.create(PARENT_NAME + "/" + key, value.getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return cacheMap.get(key);
    }

}

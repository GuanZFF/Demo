package pers.zhenfeng.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

/**
 * @author Grow-Worm
 * @date 2019/02/26
 */
public class ZkClientTest {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient("", 10000, 10000, new SerializableSerializer());

    }

}

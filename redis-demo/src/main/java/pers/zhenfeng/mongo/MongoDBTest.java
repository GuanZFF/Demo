package pers.zhenfeng.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author Grow-Worm
 * @date 2020/10/11
 */
public class MongoDBTest {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("140.143.201.74", 27017);

        MongoDatabase database = mongoClient.getDatabase("runoob");

    }

}

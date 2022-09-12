package Util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DbConfig {

    public static MongoClient mongoClient;

    public static void initDB() {
        mongoClient =  new MongoClient(new MongoClientURI("mongodb+srv://root:root@cluster0.ht9syvq.mongodb.net/?retryWrites=true&w=majority"));
    }

    public static MongoDatabase getDatabase() {
        return mongoClient.getDatabase("inventory");
    }

    public static void disconnectDatabase() {
        mongoClient.close();
    }
}

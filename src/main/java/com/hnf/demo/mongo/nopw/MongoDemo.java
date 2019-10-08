package com.hnf.demo.mongo.nopw;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("192.168.99.117", 27017), "QQREM");
        BasicDBObject basicDBObject = new BasicDBObject("QQFREM", "兆波");
//        basicDBObject.put("CAPTURETIME", new BasicDBObject("$eq", "2016-05-18T16:00:00.000Z"));
        FindIterable<Document> qqfrem = mongoTemplate.getCollection("QQFREM").find(basicDBObject);
        for (Document document : qqfrem) {
            System.out.println(document);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

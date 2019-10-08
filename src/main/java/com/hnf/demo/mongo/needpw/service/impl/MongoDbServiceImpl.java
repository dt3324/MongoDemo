package com.hnf.demo.mongo.needpw.service.impl;

import com.hnf.demo.mongo.needpw.client.MongoDbClient;
import com.hnf.demo.mongo.needpw.service.MongoDbService;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dt
 */
@Service
public class MongoDbServiceImpl implements MongoDbService {

    private final MongoDbClient mongoDbClient;

    @Autowired
    public MongoDbServiceImpl(MongoDbClient mongoDbClient) {
        this.mongoDbClient = mongoDbClient;
    }

    @Override
    public List<Document> findAll(Integer page, Integer size) {
        if (page == null || size == null) {
            throw new RuntimeException("参数错误");
        }
        MongoClient client = mongoDbClient.getClient();
        FindIterable<Document> skip = client.getDatabase("infoData").getCollection("message").find().limit(size).skip((page - 1) * size);
        ArrayList<Document> documents = new ArrayList<>();
        for (Document document : skip) {
            documents.add(document);
        }
        return documents;
    }

    @Override
    public List<Document> findBySearch(String search, Integer page, Integer size) {
        if (page == null || size == null) {
            throw new RuntimeException("参数错误");
        }
        MongoClient client = mongoDbClient.getClient();
        BasicDBObject query = new BasicDBObject("senderuin", search);
        FindIterable<Document> documents = client.getDatabase("infoData").getCollection("qqmsg").find(query);
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            result.add(document);
        }
        return result;
    }

    @Override
    public List<Document> findInList(List<String> list, Integer page, Integer size) {
        MongoClient client = mongoDbClient.getClient();
        BasicDBObject query = new BasicDBObject("senderuin", new BasicDBObject(QueryOperators.IN, list));
        FindIterable<Document> documents = client.getDatabase("infoData").getCollection("qqmsg").find(query);
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            result.add(document);
        }
        return result;
    }
}

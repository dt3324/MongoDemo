package com.hnf.demo.mongo.test;

import com.hnf.demo.mongo.Application;
import com.hnf.demo.mongo.needpw.client.MongoDbClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class MongoTest {
    @Autowired
    private MongoDbClient mongoClient;

    @Test
    public void test(){
        System.out.println(mongoClient.getClient());
    }
}

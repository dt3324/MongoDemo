package com.hnf.demo.mongo.needpw.service.impl;

import com.hnf.demo.mongo.Application;
import com.hnf.demo.mongo.needpw.service.MongoDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest(classes = Application.class)
@RunWith(value = SpringRunner.class)
public class MongoDbServiceImplTest {

    @Autowired
    private MongoDbService mongoDbService;

    @Test
    public void findAll() {
        System.out.println(mongoDbService.findAll(0, 50));
    }

    @Test
    public void findBySearch() {
        System.out.println(mongoDbService.findBySearch("2419768456", 0, 20));
    }

    @Test
    public void findInList() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1552921566");
        objects.add("2419768456");
        System.out.println(mongoDbService.findInList(objects, 0, 20));
    }

}
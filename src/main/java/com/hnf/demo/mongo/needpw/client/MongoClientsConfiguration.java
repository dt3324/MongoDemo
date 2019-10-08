package com.hnf.demo.mongo.needpw.client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDriverInformation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.hnf.demo.mongo.util.ObjectUtil.getInteger;
import static com.hnf.demo.mongo.util.ObjectUtil.getString;

/**
 * @author hnf
 */
//@Configuration
//@ConfigurationProperties(prefix = "mongo")
public class MongoClientsConfiguration {

    public static final String MONGO_CLUSTER = "mongoBase";
    public static final String MONGO_BASE = "mongoBase";
    public static final String MONGO_VIRTUAL = "mongoBase";
    public static final String MONGO_SIS = "mongoBase";
    public static final String MONGO_ALARM = "mongoBase";
    public static final String MONGO_GIS = "mongoBase";

    private String clusterUsername;
    private String clusterPassword;
    private String clusterDb;
    private List<Map> clusterHosts;


    @Primary
    @Bean(name = MONGO_CLUSTER)
    public MongoClient getMongoClient() {
        List<ServerAddress> addresses = new LinkedList<>();
        clusterHosts.stream().filter(map -> getString(map.get("ip")) != null && getInteger(map.get("port")) != null)
                .forEach(map -> addresses.add(new ServerAddress(getString(map.get("ip")), getInteger(map.get("port")))));
        MongoCredential credential = MongoCredential.createCredential(clusterUsername, clusterDb, clusterPassword.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoDriverInformation information = MongoDriverInformation.builder().build();
        return new MongoClient(addresses, credential, options, information);
    }

    public void setClusterUsername(String clusterUsername) {
        this.clusterUsername = clusterUsername;
    }

    public void setClusterPassword(String clusterPassword) {
        this.clusterPassword = clusterPassword;
    }

    public void setClusterDb(String clusterDb) {
        this.clusterDb = clusterDb;
    }

    public void setClusterHosts(List<Map> clusterHosts) {
        this.clusterHosts = clusterHosts;
    }
}

package com.hnf.demo.mongo.needpw.client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDriverInformation;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author dt
 */
@Component
@ConfigurationProperties(prefix = "mongo")
//@Lazy(value = false)
public class MongoDbClient {
    private String ip;
    private Integer port;
    private String username;
    private String password;
    private String clusterDb;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClusterDb(String clusterDb) {
        this.clusterDb = clusterDb;
    }

    public MongoClient getClient(){
        ServerAddress serverAddress = new ServerAddress(ip, port);
        MongoCredential credential = MongoCredential.createCredential(username, clusterDb, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoDriverInformation information = MongoDriverInformation.builder().build();
        return new MongoClient(serverAddress, credential, options, information);
    }
}

package com.hnf.demo.mongo.needpw.service;

import org.bson.Document;

import java.util.List;

/**
 * @author dt
 */
public interface MongoDbService {
    /**
     * 查询所有限制条数
     * @param page 查询哪页
     * @param size 查询条数
     * @return 返回结果
     */
    List<Document> findAll(Integer page,Integer size);

    /**
     * 条件查询
     * @param search 查询条件
     * @param page 查询那页
     * @param size 查询条数
     * @return 查询结果
     */
    List<Document> findBySearch(String search,Integer page,Integer size);

    /**
     * 条件查询
     * @param list 查询条件
     * @param page 查询那页
     * @param size 查询条数
     * @return 查询结果
     */
    List<Document> findInList(List<String> list,Integer page,Integer size);


}

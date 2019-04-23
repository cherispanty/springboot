package com.atguigu.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.atguigu.elastic.bean.Book;

/**
 * @author linchong
 * @create 2019-04-23 11:04
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}

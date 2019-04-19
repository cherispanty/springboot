package com.atguigu.amqp;

import com.atguigu.amqp.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 点对点
     */
    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg","hello");
        map.put("data", Arrays.asList("my precious",true,123));
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",map);
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",new Book("八十天环游地球",100.2));
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.emps");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 多播
     */
    @Test
    public void test1() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国演义",99.99));
    }



}

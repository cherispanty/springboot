package com.atguigu.amqp;

import com.atguigu.amqp.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    @Autowired
    private AmqpAdmin amqpAdmin;

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
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦",99.99));
    }

    /**
     * 创建Exchange
     */
    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true)) ;
//        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.hahha",null));
//        amqpAdmin.deleteQueue("amqpAdmin.queue");
            amqpAdmin.deleteExchange("amqpAdmin.exchange");

    }



}

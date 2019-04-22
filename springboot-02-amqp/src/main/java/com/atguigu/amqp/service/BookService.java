package com.atguigu.amqp.service;

import com.atguigu.amqp.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-04-19 16:45
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.emps")
    public void receive(Book book){
        System.out.println("收到消息："+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}

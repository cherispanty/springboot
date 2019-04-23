package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-04-23 11:46
 */
@Service
public class HelloService {

    @Async
    public void hello() {
        System.out.println("准备处理...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理完毕...");
 }
}

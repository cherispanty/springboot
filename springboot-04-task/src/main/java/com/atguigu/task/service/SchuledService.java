package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author linchong
 * @create 2019-04-23 11:55
 */
@Service
public class SchuledService {

    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello...."+new Date());
    }
}

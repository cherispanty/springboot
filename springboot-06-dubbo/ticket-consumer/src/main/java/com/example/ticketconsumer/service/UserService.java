package com.example.ticketconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.ticketprovider.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-04-24 11:34
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public String hello() {
        return ticketService.ticket();
    }
}

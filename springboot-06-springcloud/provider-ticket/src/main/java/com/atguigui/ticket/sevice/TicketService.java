package com.atguigui.ticket.sevice;

import org.springframework.stereotype.Service;

/**
 * @author linchong
 * @create 2019-04-24 17:30
 */
@Service
public class TicketService {

    public String buy(String movieName) {
        return "购买《"+movieName+"》成功";
    }
}

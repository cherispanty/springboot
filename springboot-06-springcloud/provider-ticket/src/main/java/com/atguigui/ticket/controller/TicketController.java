package com.atguigui.ticket.controller;

import com.atguigui.ticket.sevice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author linchong
 * @create 2019-04-24 17:32
 */
@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/buyTicket")
    @ResponseBody
    public String buyTicket() {
        return ticketService.buy("复仇者联盟");
    }
}

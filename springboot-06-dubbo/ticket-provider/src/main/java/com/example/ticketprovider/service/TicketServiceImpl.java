package com.example.ticketprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author linchong
 * @create 2019-04-24 11:32
 */
@Component
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String ticket() {
        return "<<复仇者联盟·4>>";
    }
}

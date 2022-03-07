package com.hyb.gmall;

import com.hyb.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = applicationContext.getBean(OrderService.class);

        orderService.initOrder("1");

        System.out.println("调用结束..........");
        System.in.read();

    }
}

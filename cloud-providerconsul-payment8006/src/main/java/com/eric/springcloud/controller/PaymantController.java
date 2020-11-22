package com.eric.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author EricRaww
 * @create 2020-11-22
 */
@RestController
@Slf4j
public class PaymantController {
   @Value("${server.port}")
    private String serverPort;
   @RequestMapping(value = "/payment/consul")
   public String paymentconsul(){
       return "Springcloud with consul"+serverPort+"\t"+ UUID.randomUUID().toString();
   }

}

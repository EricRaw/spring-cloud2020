package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-22
 */
@RestController
@Slf4j
public class OrderController {

    public static final String url="http://cloud-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/zk")
    public String getfromZK(){
        return restTemplate.getForObject(url+"/payment/zk",String.class);
    }

}

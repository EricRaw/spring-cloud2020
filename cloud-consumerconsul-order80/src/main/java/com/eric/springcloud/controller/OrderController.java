package com.eric.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-22
 */
@RestController
public class OrderController {
    @Resource
    RestTemplate restTemplate;
    private static final String URL="http://cloud-providerconsul-payment8006";
    @GetMapping(value = "/consumer/payment/consul")
    public String getfromconsul(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}

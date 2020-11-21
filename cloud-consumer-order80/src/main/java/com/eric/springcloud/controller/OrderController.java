package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8001/payment/";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";


    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentbyId(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);

    }
}

package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import com.eric.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-23
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    PaymentFeignService paymentFeignService;
    @GetMapping(value ="/consumer/{id}" )
    public CommonResult<Payment> getFeignById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentbyId(id);
    }
    @GetMapping(value = "/consumer/timeout")
    public String getTimeout(){
        return paymentFeignService.paymentTimeout();
    }

}

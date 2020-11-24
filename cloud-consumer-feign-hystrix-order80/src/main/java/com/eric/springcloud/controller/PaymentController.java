package com.eric.springcloud.controller;

import com.eric.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
//@DefaultProperties(defaultFallback = "paymentInfo_Timeoutfallback",
//commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
public class PaymentController {
    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }
    @GetMapping(value = "/consumer/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Timeoutfallback",
//    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
//    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }
    public String paymentInfo_Timeoutfallback(){
        return "你好，服务器繁忙，请稍后再试--通用的调用者方法";
    }
    public String payment_global_fallbackmethod(){
        return "你好，服务器繁忙，请稍后再试--全局";
    }
}

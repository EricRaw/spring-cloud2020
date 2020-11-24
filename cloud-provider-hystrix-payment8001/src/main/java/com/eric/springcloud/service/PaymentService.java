package com.eric.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2020-11-23
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池： "+Thread.currentThread().getName()+", id is "+id;
    }

    @HystrixCommand(fallbackMethod = "myFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_Timeout(Integer id){
        int timeNumber=5;
//        int i=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+",TIMEOUT id is "+id;
    }
    public String myFallBack(Integer id){
        return "服务器繁忙，请稍后再试";
    }
    /**
     * 以下是服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties ={
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    } )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id 不能为负数");
        }
        String s = IdUtil.fastUUID();
        return Thread.currentThread().getName()+"调用成功，流水号是"+s;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试。来自服务熔断";
    }

}

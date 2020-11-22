package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import com.eric.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value ="/payment")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"success"+serverPort,result);
        }else {
            return new CommonResult(500,"fail"+serverPort);
        }
    }
    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment !=null){
            return new CommonResult(200,"success"+serverPort,payment);
        }else {
            return new CommonResult(500,"fail"+serverPort,"no data");
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> stringList = discoveryClient.getServices();
        for(String s:stringList){
            log.info("******element: "+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLoadBalance(){
        return serverPort;
    }
    @GetMapping(value = "/payment/timeout")
    public String paymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

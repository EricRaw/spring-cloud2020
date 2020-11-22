package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import com.eric.springcloud.mylb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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
    @Resource
    LoadBalancer loadBalancer;
    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentbyId(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);

    }
    @GetMapping(value = "/consumer/payment/entity/{id}")
    public CommonResult<Payment> getpayment(@PathVariable("id") Long id){
       ResponseEntity<CommonResult> entity= restTemplate.getForEntity(PAYMENT_URL+"/payment/"+id,CommonResult.class);
       if(entity.getStatusCode().is2xxSuccessful()){
           return entity.getBody();
       }else {
           return new CommonResult<>(400,"operate fail");
       }
    }
    @GetMapping(value = "/comsumer/payment/lb")
    public CommonResult<Payment> getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return  restTemplate.getForObject(uri+"/payment/1",CommonResult.class);
    }
}

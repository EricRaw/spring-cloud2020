package com.eric.springcloud.controller;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import com.eric.springcloud.service.PaymentService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
   @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        Log.info("********插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "success"+serverPort,result);
        } else {
            return new CommonResult(404, "fail"+serverPort);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentbyId(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentbyId(id);
        Log.info("@@@@@@@@查询结果"+payment.toString()+" 结果如何？");

        if (payment !=null){
            return new CommonResult(200, "success"+serverPort,payment);
        } else {
            return new CommonResult(404, "fail"+serverPort);
        }
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




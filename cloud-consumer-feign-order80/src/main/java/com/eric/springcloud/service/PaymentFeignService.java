package com.eric.springcloud.service;

import com.eric.springcloud.entities.CommonResult;
import com.eric.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author EricRaww
 * @create 2020-11-23
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/{id}")
    CommonResult<Payment> getPaymentbyId(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/timeout")
    public String paymentTimeout();
}

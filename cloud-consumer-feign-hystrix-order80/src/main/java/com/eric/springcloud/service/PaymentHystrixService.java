package com.eric.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author EricRaww
 * @create 2020-11-23
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);
    @GetMapping(value = "/payment/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);

}

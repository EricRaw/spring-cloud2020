package com.eric.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author EricRaww
 * @create 2020-11-24
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "你好，服务器繁忙，来自feign client" ;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "你好，服务器繁忙，来自feign client" ;
    }
}

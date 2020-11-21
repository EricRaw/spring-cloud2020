package com.eric.springcloud.service;


import com.eric.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}

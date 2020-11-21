package com.eric.springcloud.dao;

import com.eric.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentbyId(@Param("id") Long id);


}

package com.eric.springcloud.service;

import com.eric.springcloud.dao.PaymentDao;
import com.eric.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

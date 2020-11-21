package com.eric.springcloud.service;

import com.eric.springcloud.dao.PaymentDao;
import com.eric.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@Service
public class PaymentSericeImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentbyId(Long id) {
        return paymentDao.getPaymentbyId(id);
    }
}

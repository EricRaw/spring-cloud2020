package com.eric.springcloud.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author EricRaww
 * @create 2020-11-22
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}

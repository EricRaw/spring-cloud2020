package com.eric.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@Configuration
public class ApplicationContextConfig {
    //applicationContext.xml
    //<bean id="" class="">
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

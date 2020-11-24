package com.eric.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author EricRaww
 * @create 2020-11-24
 */
@SpringBootApplication
@EnableEurekaClient
public class GatawayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatawayMain9527.class,args);
    }
}

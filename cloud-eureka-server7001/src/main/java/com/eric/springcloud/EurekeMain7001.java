package com.eric.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekeMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekeMain7001.class,args);
    }
}

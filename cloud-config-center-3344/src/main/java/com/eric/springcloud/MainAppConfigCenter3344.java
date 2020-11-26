package com.eric.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author EricRaww
 * @create 2020-11-25
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class MainAppConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class,args);
    }
}

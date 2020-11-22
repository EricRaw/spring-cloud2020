package com.eric.myribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author EricRaww
 * @create 2020-11-22
 */
@Configuration
public class MyRibbonRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

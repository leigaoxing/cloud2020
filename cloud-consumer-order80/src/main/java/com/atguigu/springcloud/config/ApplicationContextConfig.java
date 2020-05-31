package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author adminitrator
 * date: 2020/5/13
 */
@Configuration
public class ApplicationContextConfig {
    //通过该注解解决 使用服务名 访问服务的时候，要有负载均衡机制，比如，轮询
//    @LoadBalanced//使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

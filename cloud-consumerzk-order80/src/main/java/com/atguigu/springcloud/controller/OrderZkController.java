package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author adminitrator
 * date: 2020/5/23
 */
@RestController
public class OrderZkController {

    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Value("${server.port")
    private String ServerPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentZk() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}

package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author adminitrator
 * date: 2020/5/31
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentinfo_OK(Integer id) {
        return "********PaymentFallbackService.paymentinfo_OK，O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentinfo_TimeOut(Integer id) {
        return "********PaymentFallbackService.paymentinfo_TimeOut，O(∩_∩)O哈哈~";
    }
}

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author adminitrator
 * date: 2020/5/30
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentinfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand/*(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    public String paymentinfo_TimeOut(@PathVariable("id") Integer id) {
//        int age = 10/0;
        return paymentHystrixService.paymentinfo_TimeOut(id);
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "我是消费者 80 ，对方支付系统繁忙请 10 秒钟之后再试或者自己运行出错请检查机子，o(╥﹏╥)o：\t" + "\t当前线程名字" + Thread.currentThread().getName();
    }

    /**
     * 全局 fallback 方法
     *
     * @return
     */
    public String payment_global_fallbackMethod() {
        return "global 异常处理信息，请稍后再试O(∩_∩)O哈哈~";
    }
}

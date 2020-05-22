package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: gaoxinglei
 * @date: 2020/5/21
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 创建 payment
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {

            return new CommonResult(200, "插入数据成功，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "插入数据失败");
        }
    }

    /**
     * 查询 payment
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果：" + result + "O(∩_∩)O哈哈~");
        if (result != null) {

            return new CommonResult(200, "查询成功，serverPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "没有对应的记录，查询 id：" + id);
        }
    }
}

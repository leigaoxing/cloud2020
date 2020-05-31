package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义一个负载均衡接口
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);
}

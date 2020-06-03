package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author adminitrator
 * date: 2020/6/2
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个id 为 payment_route 的路由规则
     * 当访问地址 http://localhost:9527/guonei 时会自动跳转到地址：http://news.baidu.com/guonei
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routesGuonei(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment_route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
    }

    @Bean
    public RouteLocator routesGuoji(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment_route", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
    }
}

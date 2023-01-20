package com.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayCnf {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/employee-service/**")
                        .uri("lb://employee-service"))
                .route(p -> p.path("/workhour-service/**")
                        .uri("lb://workhour-service"))
                .route(p -> p.path("/accounting-service/**")
                        .uri("lb://accounting-service"))
                .build();
    }

}

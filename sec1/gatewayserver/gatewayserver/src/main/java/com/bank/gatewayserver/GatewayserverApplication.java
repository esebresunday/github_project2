package com.bank.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                                .path("/esebresunday/accounts/**")
                                .filters(f -> f.rewritePath("/esebresunday/accounts/(?<segment>.*)","/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                                .uri("lb://ACCOUNTS"))
                .route(p -> p
                                .path("/esebresunday/loans/**")
                                .filters(f -> f.rewritePath("/esebresunday/loans/(?<segment>.*)","/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                                .uri("lb://LOANS"))
                .route(p -> p
                                .path("/esebresunday/cards/**")
                                .filters(f -> f.rewritePath("/esebresunday/cards/(?<segment>.*)","/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                                .uri("lb://CARDS"))
                .build();


    }
}

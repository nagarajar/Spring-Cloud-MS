package com.app.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {
	
	@Bean
	public RouteLocator configRoutes(RouteLocatorBuilder builder)
	{
		return builder.routes()
					//.route("cartRoutingId", r -> r.path("/cart/**").uri("http://172.10.12.36:9696")) //If only one Instance Running
					.route("cartRoutingId", r -> r.path("/cart/**").uri("lb://CART-SERVICE"))
					.route("orderRoutingId", r -> r.path("/order/**").uri("lb://ORDER-SERVICE"))
					.build();
	}
}

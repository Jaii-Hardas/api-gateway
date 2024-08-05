package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            "directory-service", r -> r.path("/api/v1/auth/user/**").uri("lb://directory-service"))
        .route("patient-service", r -> r.path("/api/v1/patient/**").uri("lb://patient-service"))
        .route("case-service", r -> r.path("/api/v1/case/**").uri("lb://case-service"))
        .route(
            "appointment-service",
            r -> r.path("/api/v1/appointment/**").uri("lb://appointment-service"))
        .build();
  }
}

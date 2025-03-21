package com.stech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import java.net.URI;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;

import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.forward;

@Configuration
public class GatewayConfig {

	@Bean
	RouterFunction<ServerResponse> getRoute() {
		return GatewayRouterFunctions.route("default-route").route(path("/users/**"), HandlerFunctions.http("http://localhost:8081/users"))
				.route(path("/orders/**"), HandlerFunctions.http("http://localhost:8082/orders"))
				.onError(e -> e instanceof IllegalArgumentException,
						(e, request) -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build())
				.build();
	}

	/*
	 * @Bean RouterFunction<ServerResponse> getRoutes() { return
	 * GatewayRouterFunctions.route() .route(path("/users/**"), req ->
	 * ServerResponse.permanentRedirect(URI.create("http://localhost:8081" +
	 * req.path())).build()) .route(path("/orders/**"), req ->
	 * ServerResponse.permanentRedirect(URI.create("http://localhost:8082" +
	 * req.path())).build()) .build(); }
	 */
}

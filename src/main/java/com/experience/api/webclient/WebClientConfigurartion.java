package com.experience.api.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfigurartion {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}

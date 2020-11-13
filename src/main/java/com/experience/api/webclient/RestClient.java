package com.experience.api.webclient;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestClient {

	@Autowired
	private WebClient.Builder restClient;

	public Mono<ClientResponse> get(Map<String, String> headers, String uri) {

		return restClient.build()
				.get()
				.uri(uri)
				.headers(customHeaders -> {
					// set Default headers
					customHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

					headers.forEach((key, value) -> {
						customHeaders.set(key, value);
					});
				})
				.exchange();
	}

	public Mono<ClientResponse> post(Map<String, String> headers, String uri, Object rquestObj) {

		return restClient.build()
				.post()
				.uri(uri)
				.body(Mono.just(rquestObj), Object.class)
				.headers(customHeaders -> {
					// set Default headers
					customHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
					headers.forEach((key, value) -> {
						customHeaders.set(key, value);
					});
				})
				.exchange();
	}

}

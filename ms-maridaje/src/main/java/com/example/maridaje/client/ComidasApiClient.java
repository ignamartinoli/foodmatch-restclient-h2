package com.example.maridaje.client;

import com.example.maridaje.domain.dto.ComidaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ComidasApiClient {
	private final RestClient client;

	public ComidasApiClient(RestClient comidasClient) {
		this.client = comidasClient;
	}

	public ComidaDTO obtenerPorId(Integer id) {
		return client.get()
				.uri("/api/comidas/{id}", id)
				.retrieve()
				.body(ComidaDTO.class);
	}
}

package com.example.maridaje.web;

import com.example.maridaje.client.ComidasApiClient;
import com.example.maridaje.domain.dto.*;
import com.example.maridaje.service.MotorMaridaje;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maridaje")
public class MaridajeController {
	private final ComidasApiClient comidas;
	private final MotorMaridaje motor;

	public MaridajeController(ComidasApiClient c, MotorMaridaje m) {
		this.comidas = c;
		this.motor = m;
	}

	@GetMapping("/{idComida}")
	public ResponseEntity<BebidaDTO> sugerirPorId(@PathVariable Integer idComida) {
		ComidaDTO comida = comidas.obtenerPorId(idComida);
		return ResponseEntity.ok(motor.sugerir(comida));
	}

	@PostMapping
	public ResponseEntity<BebidaDTO> sugerirPorBody(@RequestBody ComidaDTO comida) {
		return ResponseEntity.ok(motor.sugerir(comida));
	}
}

package com.example.comidas.web;

import com.example.comidas.domain.Comida;
import com.example.comidas.repo.ComidaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {
	private final ComidaRepository repo;

	public ComidaController(ComidaRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public List<Comida> listar(@RequestParam(required = false) String q) {
		return (q == null || q.isBlank()) ? repo.findAll() : repo.search(q);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comida> detalle(@PathVariable Integer id) {
		return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
}

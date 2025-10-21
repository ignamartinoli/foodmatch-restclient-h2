package com.example.maridaje.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComidaDTO {
	private Integer id;
	private String nombre;
	private String tipo;
	private boolean picante;
	private String perfil;
	private String grasa;
}

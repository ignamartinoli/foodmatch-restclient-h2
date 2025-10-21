package com.example.comidas.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String tipo; // PIZZA | SUSHI | HAMBURGUESA | ASADO | PASTA | POSTRE ...

	private boolean picante;

	private String perfil; // SALADO | DULCE | UMAMI

	private String grasa; // BAJA | MEDIA | ALTA
}

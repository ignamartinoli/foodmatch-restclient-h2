package com.example.maridaje.service;

import com.example.maridaje.domain.dto.BebidaDTO;
import com.example.maridaje.domain.dto.ComidaDTO;
import org.springframework.stereotype.Component;

@Component
public class MotorMaridaje {
	public BebidaDTO sugerir(ComidaDTO c) {
		if (c == null)
			return new BebidaDTO("Agua", "AGUA", "Fallback");

		String tipo = c.getTipo();

		if ("PIZZA".equals(tipo))
			return b("Cerveza Lager", "CERVEZA", "Limpia grasas de masa/queso");
		if ("SUSHI".equals(tipo))
			return b("Sake / Té verde", "TÉ", "Perfiles limpios para pescado/arroz");
		if ("HAMBURGUESA".equals(tipo))
			return b("Cerveza IPA", "CERVEZA", "Amargor corta grasa alta");
		if ("ASADO".equals(tipo))
			return b("Malbec", "VINO", "Taninos para carnes rojas");
		if ("PASTA".equals(tipo))
			return b("Vino Blanco Seco", "VINO", "Acidez para salsas cremosas");
		if ("POSTRE".equals(tipo))
			return b("Café o Porto", "REFRESCO", "Dulzor/amargor equilibran");
		if (c.isPicante())
			return b("Cerveza de Trigo / Lassi", "CERVEZA", "Cuerpo refrescante calma el picante");
		if ("ALTA".equals(c.getGrasa()))
			return b("Agua con gas o IPA suave", "AGUA", "Carbonatación limpia paladar");
		if ("DULCE".equals(c.getPerfil()))
			return b("Infusión / Café", "TÉ", "Amargor equilibra dulces");

		return b("Agua con gas", "AGUA", "Siempre combina");
	}

	private BebidaDTO b(String n, String t, String r) {
		return new BebidaDTO(n, t, r);
	}
}

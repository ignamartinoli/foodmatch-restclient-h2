package com.example.comidas.repo;

import com.example.comidas.domain.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ComidaRepository extends JpaRepository<Comida, Integer> {
	@Query("select c from Comida c where :q is null or lower(c.nombre) like lower(concat('%', :q, '%'))")
	List<Comida> search(String q);
}

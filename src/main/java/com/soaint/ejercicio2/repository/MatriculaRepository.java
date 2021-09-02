package com.soaint.ejercicio2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soaint.ejercicio2.entities.Estudiante;

public interface MatriculaRepository extends JpaRepository<Estudiante, Long> {

	public List<Estudiante> findListByEdadAndEstado(Integer edad, String estado);
	
}

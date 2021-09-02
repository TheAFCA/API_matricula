package com.soaint.ejercicio2.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soaint.ejercicio2.entities.Estudiante;
import com.soaint.ejercicio2.entities.EstudianteResponse;

@Component
public class EntityToConverted {
	@Autowired
	private ModelMapper modelMapper;
	
	public EstudianteResponse convertirEntidad(Estudiante estudiante) {
		return modelMapper.map(estudiante, EstudianteResponse.class);
	}
	
	public List<EstudianteResponse> convertirEntidad(List<Estudiante> estudiantes) {
		return estudiantes.stream()
				.map(estudiante -> convertirEntidad(estudiante))
				.collect(Collectors.toList());
	}
}

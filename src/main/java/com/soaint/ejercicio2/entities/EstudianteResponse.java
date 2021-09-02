package com.soaint.ejercicio2.entities;

import lombok.Data;

@Data
public class EstudianteResponse {

	private Long id;
	private String nombre;
	private String numeroIdentificacion;
	private String correoElectronico;
	private Integer edad;
	private String estado;
	
}

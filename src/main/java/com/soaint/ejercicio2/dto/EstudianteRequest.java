package com.soaint.ejercicio2.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Representa la información del estudiante")
public class EstudianteRequest {

	@ApiModelProperty(notes = "nombre del estudiante", example = "Andres", required = true)
	private String nombre;
	@ApiModelProperty(notes = "numero de identificacion del estudiante", example = "1075381234", required = true)
	private String numeroIdentificacion;
	@ApiModelProperty(notes = "correo electronico o email del estudiante", example = "algo@gamil.com", required = true)
	private String correoElectronico;
	@ApiModelProperty(notes = "Edad del estudiante", example = "16", required = true)
	private Integer edad;
	
	private List<AcudienteRequest> acudientes;
	
}

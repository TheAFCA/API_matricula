package com.soaint.ejercicio2.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "Representa la información del acudiente")
public class AcudienteRequest {

	@ApiModelProperty(notes = "nombre del acudiente", example = "Sonia", required = true)
	private String nombre;
	@ApiModelProperty(notes = "parentesco con el estudiate", example = "Mamá", required = true)
	private String parentesco;
	@ApiModelProperty(notes = "numero de celular", example = "3114197810", required = true)
	private String nTelefono;
	
}

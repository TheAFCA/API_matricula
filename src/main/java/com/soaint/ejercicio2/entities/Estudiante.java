package com.soaint.ejercicio2.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_estudiantes")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero_estudiante", length = 50)
	private String nombre;
	@Column(name = "numero_identificacion", length = 30)
	private String numeroIdentificacion;
	@Column(name = "correo_electronico", length = 30)
	private String correoElectronico;
	@Column(name = "edad")
	private Integer edad;
	@Column(name = "estado")
	private String estado;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "estudiante")
	private List<Acudiente> acudientes;
}

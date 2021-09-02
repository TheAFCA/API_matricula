package com.soaint.ejercicio2.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_acudiente")
public class Acudiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_acudiente", length = 50)
	private String nombre;
	@Column(name = "parentesco", length = 30)
	private String parentesco;
	@Column(name = "numero_telefono", length = 30)
	private String nTelefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Estudiante estudiante;

}

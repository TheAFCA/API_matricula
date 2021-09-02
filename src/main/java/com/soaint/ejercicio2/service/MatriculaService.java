package com.soaint.ejercicio2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soaint.ejercicio2.dto.EstudianteRequest;
import com.soaint.ejercicio2.entities.Acudiente;
import com.soaint.ejercicio2.entities.Estudiante;
import com.soaint.ejercicio2.repository.MatriculaRepository;

@Service
public class MatriculaService {
	@Autowired
	private MatriculaRepository matriculaRepository;

	public Estudiante crearEstudiante(EstudianteRequest payload) {
		Estudiante estudiante = new Estudiante();

		estudiante.setNombre(payload.getNombre());
		estudiante.setNumeroIdentificacion(payload.getNumeroIdentificacion());
		estudiante.setCorreoElectronico(payload.getCorreoElectronico());
		estudiante.setEdad(payload.getEdad());
		estudiante.setEstado("ACTIVO");

		List<Acudiente> acudientes = payload.getAcudientes().stream()
				.map(acudiente -> Acudiente.builder()
						.nombre(acudiente.getNombre())
						.parentesco(acudiente.getParentesco())
						.nTelefono(acudiente.getNTelefono())
						.estudiante(estudiante).build())
				.collect(Collectors.toList());

		estudiante.setAcudientes(acudientes);

		if (payload.getEdad()<18) {
			matriculaRepository.save(estudiante);
		}else {
			System.out.println("No se puede crear, estudiante MAYOR de edad");
		}
		return estudiante;

	}

	public List<Estudiante> listarEstudiantes() {
		List<Estudiante> listaEstudiantes = matriculaRepository.findAll();
		return listaEstudiantes;
	}
	
	public Estudiante consultarEstudiante(Long id) {
		Estudiante estudiante = new Estudiante();

		estudiante = matriculaRepository.findById(id).get();

		return estudiante;
	}
	
	public Estudiante eliminarEstudiante(Long id) {
		Estudiante estudianteEliminar = consultarEstudiante(id);
		estudianteEliminar.setEstado("INACTIVO");
		matriculaRepository.save(estudianteEliminar);
		return estudianteEliminar;
	}
	
	public Estudiante modificarEstudiante(Long id, EstudianteRequest payload) {
		Estudiante estudiante = consultarEstudiante(id);
		
		estudiante.setNombre(payload.getNombre());
		estudiante.setNumeroIdentificacion(payload.getNumeroIdentificacion());
		estudiante.setCorreoElectronico(payload.getCorreoElectronico());
		estudiante.setEdad(payload.getEdad());
		estudiante.setEstado("ACTIVO");

		List<Acudiente> acudientes = payload.getAcudientes().stream()
				.map(acudiente -> Acudiente.builder()
						.nombre(acudiente.getNombre())
						.parentesco(acudiente.getParentesco())
						.nTelefono(acudiente.getNTelefono())
						.estudiante(estudiante).build())
				.collect(Collectors.toList());

		estudiante.setAcudientes(acudientes);

		matriculaRepository.save(estudiante);
		return estudiante;
	}
	
	public List<Estudiante> listarByEdadEstado(Integer edad, String estado){
		return matriculaRepository.findListByEdadAndEstado(edad, estado);
	}
	
	public boolean borrarEstudiante(Long id) {
		if (matriculaRepository.existsById(id)) {
			matriculaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

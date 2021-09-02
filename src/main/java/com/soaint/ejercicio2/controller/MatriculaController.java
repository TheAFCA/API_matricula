package com.soaint.ejercicio2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.ejercicio2.dto.EstudianteRequest;
import com.soaint.ejercicio2.entities.Estudiante;
import com.soaint.ejercicio2.entities.EstudianteResponse;
import com.soaint.ejercicio2.service.MatriculaService;
import com.soaint.ejercicio2.util.EntityToConverted;

import io.swagger.annotations.ApiOperation;

@RestController
public class MatriculaController {
	@Autowired
	private MatriculaService matriculaService;
	@Autowired
	private EntityToConverted convertidor;
	
	@PostMapping(value = "matricula")
	@ApiOperation(value = "Crear Estudiante", notes = "Crea el estudiante junto con sus acudientes")
	public ResponseEntity<EstudianteResponse> crearEstudiante(@RequestBody EstudianteRequest payload){
		Estudiante estudiante = matriculaService.crearEstudiante(payload);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "matricula")
	@ApiOperation(value = "Lista Estudiantes", notes = "Lista todo los estudiantes")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiantes(){
		List<Estudiante> listaEstudiantes = matriculaService.listarEstudiantes();
		return new ResponseEntity<>(convertidor.convertirEntidad(listaEstudiantes), HttpStatus.OK);
	}
	
	@GetMapping(value = "matricula/{id}")
	@ApiOperation(value = "Busca Estudiante por id", notes = "Busca y trae un estudiante por id ingresado")
	public ResponseEntity<EstudianteResponse> buscarEstudiante(@PathVariable Long id){
		Estudiante estudiante = matriculaService.consultarEstudiante(id);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.OK);
	}
	
	@PutMapping(value = "matricula/{id}")
	@ApiOperation(value = "Elimina Estudiante por id", notes = "Cambia el estado de un estudiante de ACTIVO a INACTIVO")
	public ResponseEntity<EstudianteResponse> eliminarEstudiante(@PathVariable Long id){
		Estudiante estudiante = matriculaService.eliminarEstudiante(id);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.OK);
	}
	
	@GetMapping(value = "matriculabyedadandestado/{edad}/{estado}")
	@ApiOperation(value = "Lista Estudiantes por edad y estado", notes = "Lista todo los estudiantes traido por edad Y estado")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiantesByEdadANDEstado(@PathVariable Integer edad, @PathVariable String estado){
		List<Estudiante> listaEstudiantes = matriculaService.listarByEdadEstado(edad, estado);
		return new ResponseEntity<>(convertidor.convertirEntidad(listaEstudiantes), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "matricula/{id}")
	@ApiOperation(value = "Borra Estudiante", notes = "Borrar un estudiante por id ingresado")
	public ResponseEntity<String> borrarFactura(@PathVariable Long id) {
		boolean exist = matriculaService.borrarEstudiante(id);
		final String BORRADO = "REGISTRO BORRADO";
		final String NO_BORRADO = "REGISTRO NO BORRADO";
		if (exist == true) {
			return new ResponseEntity<>(BORRADO, HttpStatus.OK);
		}
		return new ResponseEntity<>(NO_BORRADO, HttpStatus.NOT_FOUND);
	}
}

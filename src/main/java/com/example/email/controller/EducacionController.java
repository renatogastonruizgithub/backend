package com.example.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.EducacionDTO;

import com.example.email.service.EducacionService;

@RestController
@RequestMapping("/api/educacion")
@CrossOrigin(origins = "*")
public class EducacionController {

	@Autowired
	private EducacionService educacionService;
	
	@GetMapping("")	
	public List<EducacionDTO> verEducacion() {
		return educacionService.getEducacion();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/educacion") //guarda una educacion a una persona por id
	public ResponseEntity<EducacionDTO> guardarComentario(@Validated @RequestBody EducacionDTO educacionDto){
		return new ResponseEntity<>(educacionService.crearEducacion(educacionDto),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Long id) {
		educacionService.eliminarEducacion(id);
		return ResponseEntity.status(HttpStatus.OK).build(); 
	}  
	//return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	//return new ResponseEntity<>("Persona eliminada con exito", HttpStatus.OK);
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizarEducacion/{id}")
	public ResponseEntity<EducacionDTO> actualizarPublicacion(@Validated @RequestBody EducacionDTO educacionDTO,
			@PathVariable(name = "id") Long id) {
		EducacionDTO actualizar = educacionService.actualizar(id, educacionDTO);
		return new ResponseEntity<>(actualizar, HttpStatus.OK);
	}
	
	
	
}

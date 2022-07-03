package com.example.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.ProyectosDTO;

import com.example.email.model.Proyectos;

import com.example.email.service.ProyectosService;


@RestController
@CrossOrigin(origins = "*")
public class ProyectosController {
	@Autowired	
	private ProyectosService Service;
	
	@GetMapping("/proyectos")	
	public List<ProyectosDTO> verTrabajos() {		
		return Service.verProyectos();
	}

	@PostMapping("/proyectos")
	public ResponseEntity<ProyectosDTO> guardar(@RequestBody ProyectosDTO proyec )
	{
		ProyectosDTO Guardado=Service.save(proyec);	
		return ResponseEntity.status(HttpStatus.CREATED).body(Guardado);
	}
	
	@DeleteMapping("/proyectos/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Long id) {
		Service.eliminarProyectos(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("/actualizarProyectos/{id}")
	public ResponseEntity<ProyectosDTO> actualizarTrabajos(@Validated @RequestBody ProyectosDTO proyecDTO,
			@PathVariable(name = "id") Long id) {
		ProyectosDTO actualizar =Service.actualizar(id, proyecDTO);
		return new ResponseEntity<>(actualizar, HttpStatus.OK);
	}
	
}

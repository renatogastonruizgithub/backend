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


import com.example.email.dto.TrabajosDTO;
import com.example.email.model.Trabajos;

import com.example.email.service.TrabajosService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TrabajosController {
	@Autowired	
	private TrabajosService trabajosService;
	
	@GetMapping("/trabajos")	
	public List<TrabajosDTO> verTrabajos() {
		
		return trabajosService.verTrabajos();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/trabajos")
	public ResponseEntity<Trabajos> guardar(@RequestBody Trabajos trabajos )
	{
		Trabajos Guardado=trabajosService.save(trabajos);	
		return ResponseEntity.status(HttpStatus.CREATED).body(Guardado);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/trabajos/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Long id) {
		trabajosService.eliminarTrabajos(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizarTrabajos/{id}")
	public ResponseEntity<TrabajosDTO> actualizarTrabajos(@Validated @RequestBody TrabajosDTO trabajosDTO,
			@PathVariable(name = "id") Long id) {
		TrabajosDTO actualizar =trabajosService.actualizar(id, trabajosDTO);
		return new ResponseEntity<>(actualizar, HttpStatus.OK);
	}
	
	
	
}

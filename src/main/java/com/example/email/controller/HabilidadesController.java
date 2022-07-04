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


import com.example.email.dto.HabilidadesDTO;
import com.example.email.service.HabilidadesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HabilidadesController {
	@Autowired
	private HabilidadesService service;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/habilidades") 
	public ResponseEntity<HabilidadesDTO> guardarComentario(@Validated @RequestBody HabilidadesDTO habilidadesDto){
		return new ResponseEntity<>(service.crearHabilidades(habilidadesDto),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminarHabilidad/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable(name = "id") Long id) {
		service.eliminarHabilidades(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/getHabilidades")	
	public List<HabilidadesDTO> verEducacion() {
		return service.getHabilidades();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizarHabilidades/{id}")
	public ResponseEntity<HabilidadesDTO> actualizarPublicacion(@Validated @RequestBody HabilidadesDTO habilidadesDTO,
			@PathVariable(name = "id") Long id) {
		HabilidadesDTO actualizar = service.actualizar(id, habilidadesDTO);
		return new ResponseEntity<>(actualizar, HttpStatus.OK);
	}
	
	
	
	
	
}

package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
@Autowired	
private PersonaService personaService;


@GetMapping("{id}")
public ResponseEntity<PersonaEducacionDTO> mostrar(@PathVariable Long id )

{
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(personaService.mostarPorId(id));
}




@PostMapping
public ResponseEntity<PersonaDTO> guardar(@RequestBody PersonaDTO personaDto )

{
	PersonaDTO personaGuardada=personaService.save(personaDto);
	
	return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardada);
}



}

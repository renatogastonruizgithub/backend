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

import com.example.email.dto.HomeDTO;
import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.model.Persona;
import com.example.email.service.PersonaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PersonaController {
	
@Autowired	
private PersonaService personaService;


@GetMapping("/home")	
public List<HomeDTO> verHome() {
	return personaService.getHome();
}

	@GetMapping("/sobreMi")
	public List<Persona> sobre() {
		return personaService.all();
	}


@GetMapping("/persona/{id}") //mostrar por id
public ResponseEntity<PersonaEducacionDTO> mostrar(@PathVariable Long id )
{
	return ResponseEntity.status(HttpStatus.CREATED).body(personaService.mostarPorId(id));
}
@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/guardarPersona") //
public ResponseEntity<PersonaDTO> guardar(@RequestBody PersonaDTO personaDto )
{
	PersonaDTO personaGuardada=personaService.save(personaDto);	
	return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardada);
}
@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/borrarPersona/{id}")
public ResponseEntity<Boolean> eliminar(@PathVariable(name = "id") Long id) {
	personaService.eliminarPersona(id);	
 return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	
}
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/actualizarPersona/{id}")
public ResponseEntity<PersonaDTO> actualizarPublicacion(@Validated @RequestBody PersonaDTO personaDTO,
		@PathVariable(name = "id") long id) {
	PersonaDTO actualizar = personaService.actualizarPersona(personaDTO, id);
	return new ResponseEntity<>(actualizar, HttpStatus.OK);
}


}

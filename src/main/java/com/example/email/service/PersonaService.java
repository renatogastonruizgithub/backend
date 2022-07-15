package com.example.email.service;

import java.util.List;

import com.example.email.dto.HomeDTO;
import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.model.Persona;





public interface PersonaService {

	PersonaDTO save(PersonaDTO personaDto);
	PersonaEducacionDTO mostarPorId(Long id);
	public PersonaDTO actualizarPersona(PersonaDTO persona,long id);	
	public void eliminarPersona(long id);	
	 List<HomeDTO> getHome(); //muestra solo la home


	List<Persona> all();
}

package com.example.email.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.model.Persona;

@Component
public class PersonaMapper {

	@Autowired
	private EducacionMapper educacionMapper;
	
	
	public Persona dtoToEntity(PersonaDTO dto) {
		
		Persona persona = new Persona();
		
		persona.setNombre(dto.getNombre());
		persona.setApellido(dto.getApellido());
		return persona;
	}
	
	
	public PersonaDTO entityToDto(Persona entity) {
		
		PersonaDTO dto = new PersonaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		return dto;
	}


	public PersonaEducacionDTO entityDtoCollection(Persona persona) {
		
		PersonaEducacionDTO dto = new PersonaEducacionDTO();
		dto.setId(persona.getId());
		dto.setNombre(persona.getNombre());
		dto.setApellido(persona.getApellido());
		dto.setEducacion(educacionMapper.listEntitDto(persona.getEducacion()));
		
		
		
		return dto;
	}
	
}

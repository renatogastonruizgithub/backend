package com.example.email.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.mapper.PersonaMapper;
import com.example.email.model.Persona;
import com.example.email.repository.PersonaRepository;
import com.example.email.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaMapper personaMapper;
	@Autowired
	private PersonaRepository personaRepo; 
	
	
	@Override
	public PersonaDTO save(PersonaDTO personaDto) {
		
		Persona persona =personaMapper.dtoToEntity(personaDto);
		Persona personaSave=  personaRepo.save(persona);
		
		PersonaDTO dto=personaMapper.entityToDto(personaSave);
		
		
		return dto;
	}


	@Override
	public PersonaEducacionDTO mostarPorId(Long id) {
		
		Optional<Persona> persona= personaRepo.findById(id);
		
		
		return personaMapper.entityDtoCollection(persona.get());
	}

	
}

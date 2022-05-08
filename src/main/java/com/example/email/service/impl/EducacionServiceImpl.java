package com.example.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.EducacionDTO;
import com.example.email.dto.PersonaDTO;
import com.example.email.mapper.EducacionMapper;
import com.example.email.mapper.PersonaMapper;
import com.example.email.model.Educacion;
import com.example.email.model.Persona;
import com.example.email.repository.EducacionRepository;
import com.example.email.repository.PersonaRepository;
import com.example.email.service.EducacionService;

@Service
public class EducacionServiceImpl implements EducacionService{

	@Autowired
	private EducacionMapper educacionMapper;
	@Autowired
	private EducacionRepository educacionRepo;
	@Autowired
	private PersonaRepository personaRepo;
	
	
	@Override
	public EducacionDTO save(EducacionDTO educacionDto) {
		
		Educacion educacion =educacionMapper.dtoToEntity(educacionDto);
		Educacion educacionSave=  educacionRepo.save(educacion);
		
		Persona persona=personaRepo.findAll().get(0);
		
		persona.getEducacion().add(educacionSave);
		
		personaRepo.save(persona);
		
		EducacionDTO dto=educacionMapper.entityToDto(educacionSave);
		
		return dto;
	}
	
	

}

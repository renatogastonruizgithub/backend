package com.example.email.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.EducacionDTO;

import com.example.email.mapper.EducacionMapper;

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
	public EducacionDTO crearEducacion( EducacionDTO educacionDto) {		
		Educacion educacion =educacionMapper.dtoToEntity(educacionDto);
		Educacion educacionSave=  educacionRepo.save(educacion);
				
		Persona persona=personaRepo.findAll().get(0);		
		persona.getEducacion().add(educacionSave);		
		personaRepo.save(persona);		
		EducacionDTO dto=educacionMapper.entityToDto(educacionSave);		
		return dto;
	}
	
	
	public void eliminarEducacion( Long eduid) {		
		Persona persona = personaRepo.findAll().get(0);
		persona.getEducacion().remove(this.educacion(eduid));		
		educacionRepo.deleteById(eduid);
	}


	@Override
	public EducacionDTO actualizar(Long id, EducacionDTO educacionDto) {		
		Educacion educacion=this.educacion(id);
		
		educacion.setInfo(educacionDto.getInfo());
		educacion.setTitulo(educacionDto.getTitulo());
		educacion.setInstituto(educacionDto.getInstituto());
		educacion.setFin(this.String2LocalDate(educacionDto.getFin()));
		educacion.setInicio(this.String2LocalDate(educacionDto.getInicio()));
		return educacionMapper.entityToDto(educacionRepo.save(educacion));
	
	}

	
	private Educacion educacion(Long id) {
		Optional<Educacion> educacion=educacionRepo.findById(id);
		return educacion.get();
	}
	
	
	
	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }


	@Override
	public List<EducacionDTO> getEducacion() {
		
		return educacionRepo.findAll().stream().map(educacionMapper::entityToDto).collect(Collectors.toList());
	}
	


}

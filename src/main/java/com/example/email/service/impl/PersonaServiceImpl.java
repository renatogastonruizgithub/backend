package com.example.email.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.HomeDTO;
import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;
import com.example.email.excepciones.AppException;
import com.example.email.mapper.EducacionMapper;
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
	@Transactional
	public PersonaDTO save(PersonaDTO personaDto) {
	
			if(personaRepo.count()>0) {
				throw new RuntimeException("no se puede agregar, edite o elimine los datos");
			}
		Persona persona =personaMapper.dtoToEntity(personaDto);
		Persona personaSave=  personaRepo.save(persona);		
			PersonaDTO dto=personaMapper.entityToDto(personaSave);			
			return dto;
	}
		
	@Override
	public PersonaEducacionDTO mostarPorId(Long id) {		
		Optional<Persona> persona= personaRepo.findById(id);
		return personaMapper.entityDtoCollection(persona.get());
		//lanzar execptions si no lo encuentra
	}

	@Override
	public List<HomeDTO> getHome() {		
		return personaRepo.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
		
	}

	@Override
	public List<Persona> all() {
		return  personaRepo.findAll();
	}


	@Override
	@Transactional
	public void eliminarPersona(long id) {
		personaRepo.deleteById(id);

	}


	@Override
	public PersonaDTO actualizarPersona(PersonaDTO personadto, long id) {
		Persona persona=personaRepo.findById(id)
		.orElseThrow(RuntimeException::new);	
				//esto lo hace el paquete del mapper
		
		persona.setApellido(personadto.getApellido());
		persona.setNombre(personadto.getNombre());
		persona.setDescripion(personadto.getDescripion());
		persona.setDomicilio(personadto.getDomicilio());
		persona.setImgAbout(personadto.getImgAbout());
		persona.setImgBanner(personadto.getImgBanner());
		persona.setNacimiento(this.String2LocalDate(personadto.getNacimiento()));
		persona.setNacionalidad(personadto.getNacionalidad());
		persona.setProvincia(personadto.getProvincia());
		persona.setNro(personadto.getNro());
		persona.setStack(personadto.getStack());
		persona.setTituloAbout(personadto.getTituloAbout());
		persona.setOcupacion(personadto.getOcupacion());
	
		
		/*esto es lo q quiero implementar 
		Persona personas =personaMapper.dtoToEntity(personaDto);*/
		
		Persona personaSave=  personaRepo.saveAndFlush(persona);
		PersonaDTO dto=personaMapper.entityToDto(personaSave);	
		return dto;		
		
	}

	
	private HomeDTO entityToDto(Persona entity) {		
		HomeDTO dto = new HomeDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setImgBanner(entity.getImgBanner());
		dto.setStack(entity.getStack());
		dto.setOcupacion(entity.getOcupacion());
		return dto;
	}
	
	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }
	
	
	  
	  
}

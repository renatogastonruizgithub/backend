package com.example.email.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		persona.setDescripion(dto.getDescripion());
		persona.setDomicilio(dto.getDomicilio());
		persona.setOcupacion(dto.getOcupacion());
		persona.setImgAbout(dto.getImgAbout());
		persona.setNacimiento(this.String2LocalDate(dto.getNacimiento()));
		persona.setImgBanner(dto.getImgBanner());
		persona.setNacionalidad(dto.getNacionalidad());
		persona.setNro(dto.getNro());
		persona.setProvincia(dto.getProvincia());
		persona.setStack(dto.getStack());
		persona.setTituloAbout(dto.getTituloAbout());
		return persona;
	}
	
	
	public PersonaDTO entityToDto(Persona entity) {		
		PersonaDTO dto = new PersonaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setDescripion(entity.getDescripion());
		dto.setDomicilio(entity.getDomicilio());
		dto.setImgBanner(entity.getImgBanner());
		dto.setNro(entity.getNro());
		dto.setOcupacion(entity.getOcupacion());
		dto.setTituloAbout(entity.getTituloAbout());
		dto.setStack(entity.getStack());
		dto.setImgAbout(entity.getImgAbout());
		dto.setNacimiento(entity.getNacimiento().toString());
		dto.setProvincia(entity.getProvincia()  );
		dto.setNacionalidad(entity.getNacionalidad());
		return dto;
	}


	public PersonaEducacionDTO entityDtoCollection(Persona persona) {		
		PersonaEducacionDTO dto = new PersonaEducacionDTO();
		dto.setId(persona.getId());
		dto.setNombre(persona.getNombre());
		dto.setApellido(persona.getApellido());
		dto.setDescripion(persona.getDescripion());
		dto.setDomicilio(persona.getDomicilio());
		dto.setImgBanner(persona.getImgBanner());
		dto.setNro(persona.getNro());
		dto.setOcupacion(persona.getOcupacion());
		dto.setTituloAbout(persona.getTituloAbout());
		dto.setStack(persona.getStack());
		dto.setImgAbout(persona.getImgAbout());
		dto.setNacimiento(persona.getNacimiento().toString());
		dto.setProvincia(persona.getProvincia()  );
		dto.setNacionalidad(persona.getNacionalidad());
		
		dto.setEducacion(educacionMapper.listEntitDto(persona.getEducacion()));	
		return dto;
	}
	
	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }

	
}

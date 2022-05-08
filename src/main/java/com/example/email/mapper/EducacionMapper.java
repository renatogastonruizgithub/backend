package com.example.email.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.email.dto.EducacionDTO;
import com.example.email.model.Educacion;

@Component
public class EducacionMapper {

	public Educacion dtoToEntity(EducacionDTO educacionDto) {
		Educacion educacion=new Educacion();
		
		educacion.setTitulo(educacionDto.getTitulo());
		educacion.setInfo(educacionDto.getInfo());
		return educacion;
	}

	//setear id
	public EducacionDTO entityToDto(Educacion educacionSave) {
		EducacionDTO dto = new EducacionDTO();
		
		dto.setId(educacionSave.getId());
		dto.setInfo(educacionSave.getInfo());
		dto.setTitulo(educacionSave.getTitulo());
		
		return dto;
	}

	public Collection<EducacionDTO> listEntitDto(Collection<Educacion> educacion) {
		
		
		
		
		return educacion.stream().map(t -> entityToDto(t) ).collect(Collectors.toList());
	}
	

}

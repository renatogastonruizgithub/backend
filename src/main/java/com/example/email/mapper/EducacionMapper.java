package com.example.email.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		educacion.setInstituto(educacionDto.getInstituto());
		educacion.setInicio(this.String2LocalDate(educacionDto.getInicio()));
		educacion.setFin(this.String2LocalDate(educacionDto.getFin()));
		return educacion;
	}

	//setear id
	public EducacionDTO entityToDto(Educacion educacionSave) {
		EducacionDTO dto = new EducacionDTO();		
		dto.setId(educacionSave.getId());
		dto.setInfo(educacionSave.getInfo());
		dto.setTitulo(educacionSave.getTitulo());
		dto.setInstituto(educacionSave.getInstituto());
		dto.setInicio(educacionSave.getInicio().toString());
		dto.setFin(educacionSave.getFin().toString());
		return dto;
	}

	public Collection<EducacionDTO> listEntitDto(Collection<Educacion> educacion) {
		return educacion.stream().map(t -> entityToDto(t) ).collect(Collectors.toList());
	}
	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }


}

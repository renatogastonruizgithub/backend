package com.example.email.mapper;

import org.springframework.stereotype.Component;

import com.example.email.dto.HomeDTO;

import com.example.email.model.Persona;

@Component
public class HomeMapper {	
	
	public Persona dtoToEntity(HomeDTO dto) {		
		Persona persona = new Persona();		
		persona.setNombre(dto.getNombre());
		persona.setImgBanner(dto.getImgBanner());
		persona.setApellido(dto.getApellido());
		persona.setStack(dto.getStack());
		persona.setOcupacion(dto.getOcupacion());
		return persona;
	}
	
	
	public HomeDTO entityToDto(Persona entity) {		
		HomeDTO dto = new HomeDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setImgBanner(entity.getImgBanner());
		dto.setApellido(entity.getApellido());
		dto.setOcupacion(entity.getOcupacion());
		dto.setStack(entity.getStack());
		return dto;
	}
}

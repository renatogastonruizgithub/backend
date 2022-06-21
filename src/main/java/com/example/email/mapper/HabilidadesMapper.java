package com.example.email.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import com.example.email.dto.HabilidadesDTO;

import com.example.email.model.Habilidades;

@Component
public class HabilidadesMapper {

	public Habilidades  dtoToEntity (HabilidadesDTO habilidadesDto){
		Habilidades habilidades = new Habilidades();
		habilidades.setIcono(habilidadesDto.getIcono());
		habilidades.setNombre(habilidadesDto.getNombre());
		habilidades.setNumero(habilidadesDto.getNumero());
		return habilidades;
	}
	public  HabilidadesDTO  entityToDto(Habilidades habilidadesSave) {		
		HabilidadesDTO dto=new HabilidadesDTO();		
		dto.setIcono(habilidadesSave.getIcono());
		dto.setId(habilidadesSave.getId());
		dto.setNombre(habilidadesSave.getNombre());
		dto.setNumero(habilidadesSave.getNumero());		
		return dto;
	}
	
	public Collection<HabilidadesDTO> listEntitDto(Collection<Habilidades> habilidades) {
		return habilidades.stream().map(t -> entityToDto(t) ).collect(Collectors.toList());
	}
	
	
	
}

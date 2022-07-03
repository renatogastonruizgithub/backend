package com.example.email.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.email.dto.ProyectosDTO;

import com.example.email.model.Proyectos;


@Component
public class ProyectosMapper {
	
	
	
	public Proyectos dtoToEntity(ProyectosDTO  proyectosDto){
		Proyectos proyectos= new Proyectos();
		proyectos.setDescripion(proyectosDto.getDescripcion());
		proyectos.setImagen(proyectosDto.getImagen());
		proyectos.setNombre(proyectosDto.getNombre());		
	return proyectos;
	}
	
	
	public ProyectosDTO  entityToDto(Proyectos proyectos){
		ProyectosDTO dto =  new ProyectosDTO ();
		dto.setDescripcion(proyectos.getDescripion());
		dto.setImagen(proyectos.getImagen());
		dto.setNombre(proyectos.getNombre());
		dto.setId(proyectos.getId());		
		return dto;
	}
	
	public Collection<ProyectosDTO> listEntitDto(Collection<Proyectos> proyectos) {
		return proyectos.stream().map(t -> entityToDto(t) ).collect(Collectors.toList());
	}
}

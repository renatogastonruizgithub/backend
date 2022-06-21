package com.example.email.mapper;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.email.dto.TrabajosDTO;

import com.example.email.model.Trabajos;
@Component
public class TrabajosMapper {
	public Trabajos dtoToEntity(TrabajosDTO trabajosDTO) {
		Trabajos trabajos = new Trabajos();
		trabajos.setInicio(this.String2LocalDate(trabajosDTO.getInicio()));
		trabajos.setFin(this.String2LocalDate(trabajosDTO.getFin()));
		trabajos.setCargo(trabajosDTO.getCargo());
		trabajos.setDescripcion(trabajosDTO.getDescripcion());
		trabajos.setNombre(trabajosDTO.getNombre());
		
		return trabajos;
	}
	
	
	public TrabajosDTO entityToDto(Trabajos trabajosSave) {
		TrabajosDTO dto = new TrabajosDTO();
		dto.setId(trabajosSave.getId());
		dto.setCargo(trabajosSave.getCargo());
		dto.setDescripcion(trabajosSave.getDescripcion());
		dto.setFin(trabajosSave.getFin().toString());
		dto.setInicio(trabajosSave.getInicio().toString());
		dto.setNombre(trabajosSave.getNombre());
		return dto;
	}
	
	
	public Collection<TrabajosDTO> listEntitDto(Collection<Trabajos> trabajos) {
		return trabajos.stream().map(t -> entityToDto(t) ).collect(Collectors.toList());
	}
	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }

}

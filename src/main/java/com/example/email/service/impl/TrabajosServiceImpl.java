package com.example.email.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.TrabajosDTO;
import com.example.email.mapper.TrabajosMapper;

import com.example.email.model.Persona;
import com.example.email.model.Trabajos;
import com.example.email.repository.PersonaRepository;
import com.example.email.repository.TrabajosRepository;
import com.example.email.service.TrabajosService;
@Service
public class TrabajosServiceImpl  implements TrabajosService{
	
	@Autowired
	private TrabajosMapper trabajosMapper;
	
	@Autowired
	private PersonaRepository personaRepo; 
	@Autowired
	private TrabajosRepository trabajoRepo;
	
	@Override
	public Trabajos save(Trabajos trabajos) {		
		Trabajos trabajost=trabajoRepo.save(trabajos);
		Persona persona=personaRepo.findAll().get(0);		
	 persona.getTrabajos().add(trabajost);
		personaRepo.save(persona);
		
		return trabajoRepo.save(trabajos);
	}

	@Override
	public void eliminarTrabajos(Long id) {	
		trabajoRepo.deleteById(id);
		
	}
	
	
	@Override
	public TrabajosDTO actualizar(Long id, TrabajosDTO trabajosDto) {
		//obeter el id on el metodo buscar
		Trabajos t=this.buscar(id);		
		t.setCargo(trabajosDto.getCargo());
		t.setDescripcion(trabajosDto.getDescripcion());;
		t.setFin(this.String2LocalDate(trabajosDto.getFin().toString()));
		t.setInicio(this.String2LocalDate(trabajosDto.getInicio().toString()));
		t.setNombre(trabajosDto.getNombre());
		return trabajosMapper.entityToDto(trabajoRepo.saveAndFlush(t));
	}
	
	//para buscar el id
	private Trabajos buscar(Long id) {
		Optional<Trabajos> trabajos=trabajoRepo.findById(id);
		return trabajos.get();
	}

	  public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }

	@Override
	public List<TrabajosDTO> verTrabajos() {
		
		return trabajoRepo.findAll().stream().map(trabajosMapper::entityToDto).collect(Collectors.toList());
	}

	
	
	
}

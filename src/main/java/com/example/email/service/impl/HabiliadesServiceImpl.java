package com.example.email.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.email.dto.HabilidadesDTO;
import com.example.email.mapper.HabilidadesMapper;
import com.example.email.model.Educacion;
import com.example.email.model.Habilidades;
import com.example.email.model.Persona;
import com.example.email.repository.HabilidadesRepository;
import com.example.email.repository.PersonaRepository;
import com.example.email.service.HabilidadesService;

@Service
public class HabiliadesServiceImpl  implements HabilidadesService{
	
	
	@Autowired
	private PersonaRepository personaRepo;
	@Autowired
	private HabilidadesRepository habilidaRepo;
	@Autowired
	private HabilidadesMapper habilMapper;
	
	@Override
	public HabilidadesDTO crearHabilidades(HabilidadesDTO habilidadesDto) {
		if(personaRepo.count()==0) {
			throw new RuntimeException("Primero agregue sus datos personales");
		}	
		Habilidades hab =habilMapper.dtoToEntity(habilidadesDto);
		Habilidades habSave=  habilidaRepo.save(hab);				
		Persona persona=personaRepo.findAll().get(0);		
		persona.getHabilidades().add(habSave);		
		personaRepo.save(persona);		
		HabilidadesDTO dto=habilMapper.entityToDto(habSave);		
		return dto;		
	}

	@Override
	public void eliminarHabilidades(Long  id) {
		habilidaRepo.deleteById( id);
		
	}

	@Override
	public HabilidadesDTO actualizar(Long id, HabilidadesDTO habilidadesDto) {
		Habilidades habilidad = this.habilidad(id);		
		habilidad.setIcono(habilidadesDto.getIcono());
		habilidad.setNombre(habilidadesDto.getNombre());
		habilidad.setNumero(habilidadesDto.getNumero());
		return habilMapper.entityToDto(habilidaRepo.save(habilidad));
	}

	@Override
	public List<HabilidadesDTO> getHabilidades() {	
		return habilidaRepo.findAll().stream().map(habilMapper::entityToDto).collect(Collectors.toList());
		
	}
	
	private Habilidades habilidad(Long id) {
		Optional<Habilidades> hab=habilidaRepo.findById(id);
		return hab.get();
	}

}

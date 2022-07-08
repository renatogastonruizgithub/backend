package com.example.email.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.EducacionDTO;
import com.example.email.dto.ProyectosDTO;
import com.example.email.mapper.ProyectosMapper;
import com.example.email.model.Educacion;
import com.example.email.model.Habilidades;
import com.example.email.model.Persona;
import com.example.email.model.Proyectos;
import com.example.email.repository.PersonaRepository;
import com.example.email.repository.ProyectosRepo;
import com.example.email.service.ProyectosService;

@Service
public class ProyectosServiceImpl implements ProyectosService{
	@Autowired
	private PersonaRepository personaRepo;
	@Autowired
	private ProyectosRepo proyectosrepo;
	@Autowired
	private ProyectosMapper proyectoMapper;
	
	
	
	

	@Override
	public ProyectosDTO save(ProyectosDTO proyectosDto) {
		if(personaRepo.count()==0) {
			throw new RuntimeException("Primero agregue sus datos personales");
		}	
		Proyectos p =proyectoMapper.dtoToEntity(proyectosDto);
		Proyectos PSave=  proyectosrepo.save(p);				
		Persona persona=personaRepo.findAll().get(0);		
		persona.getProyectos().add(PSave);		
		personaRepo.save(persona);		
		ProyectosDTO dto=proyectoMapper.entityToDto(PSave);		
		return dto;
	}

	@Override
	public void eliminarProyectos(Long id) {
		proyectosrepo.deleteById(id);
		
	}

	@Override
	public ProyectosDTO actualizar(Long id, ProyectosDTO pryectosDto) {
		Proyectos p = this.proyecSerch(id);		
		 p.setDescripion(pryectosDto.getDescripcion());
		 p.setNombre(pryectosDto.getNombre());
		 p.setImagen(pryectosDto.getImagen());
		return proyectoMapper.entityToDto(proyectosrepo.save(p));
	}

	@Override
	public List<ProyectosDTO> verProyectos() {
		
		return proyectosrepo.findAll().stream().map(proyectoMapper::entityToDto).collect(Collectors.toList());
	}

	private Proyectos proyecSerch(Long id) {
		Optional<Proyectos> hab=proyectosrepo.findById(id);
		return hab.get();
	}
}

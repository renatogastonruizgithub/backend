package com.example.email.service;

import java.util.List;

import com.example.email.dto.ProyectosDTO;

import com.example.email.model.Proyectos;


public interface ProyectosService {
	public	ProyectosDTO save(ProyectosDTO proyectosDto);	
	public void eliminarProyectos(Long id);
	public ProyectosDTO actualizar (Long id, ProyectosDTO proyectosDto);
	public List<ProyectosDTO> verProyectos();
}

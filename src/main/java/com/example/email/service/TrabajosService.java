package com.example.email.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.email.dto.TrabajosDTO;
import com.example.email.model.Trabajos;

@Service
public interface TrabajosService  {
	
	Trabajos save(Trabajos trabajos);	
	public void eliminarTrabajos(Long id);
	public TrabajosDTO actualizar (Long id, TrabajosDTO trabajosDto);
	public List<TrabajosDTO> verTrabajos();
}

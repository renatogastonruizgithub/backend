package com.example.email.service;

import java.util.List;

import com.example.email.dto.EducacionDTO;


public interface EducacionService {

	//EducacionDTO save(EducacionDTO educacionDto);
	public EducacionDTO crearEducacion( EducacionDTO educacionDto );
	
	public void eliminarEducacion(Long eduid);
	
	public EducacionDTO actualizar(Long id,EducacionDTO educacionDto);

	public List<EducacionDTO> getEducacion();
	
}

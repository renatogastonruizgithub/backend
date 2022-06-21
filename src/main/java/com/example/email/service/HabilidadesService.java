package com.example.email.service;

import java.util.List;


import com.example.email.dto.HabilidadesDTO;

public interface HabilidadesService {
	
	public HabilidadesDTO crearHabilidades( HabilidadesDTO habilidadesDto );	
	public void eliminarHabilidades(Long id);	
	public HabilidadesDTO actualizar(Long id,HabilidadesDTO habilidadesDto);
	public List<HabilidadesDTO> getHabilidades();
}

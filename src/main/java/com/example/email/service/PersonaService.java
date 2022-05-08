package com.example.email.service;

import com.example.email.dto.PersonaDTO;
import com.example.email.dto.PersonaEducacionDTO;

public interface PersonaService {

	PersonaDTO save(PersonaDTO personaDto);

	PersonaEducacionDTO mostarPorId(Long id);

}

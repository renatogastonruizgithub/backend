package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.EducacionDTO;

import com.example.email.service.EducacionService;

@RestController
@RequestMapping("/educacion")
public class EducacionController {

	@Autowired
	private EducacionService educacionService;
	
	
	
	
	@PostMapping
	public ResponseEntity<EducacionDTO> guardar(@RequestBody EducacionDTO educacionDto )

	{
		EducacionDTO educacionGuardada=educacionService.save(educacionDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(educacionGuardada);
		
		
	}


	
}

package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.PersonaDTO;
import com.example.email.dto.UserDTO;
import com.example.email.model.User;
import com.example.email.repository.UserRepository;
import com.example.email.service.PersonaService;
import com.example.email.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired	
	private UserService userService;

	
	@PostMapping("/login") //
	public ResponseEntity<UserDTO> guardar(@RequestBody UserDTO userDTO )
	{
		UserDTO login=userService.save(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);
	}
	/*
	 * crear dto de user aca le paso user y pass
	 * 
	 * */
	
}

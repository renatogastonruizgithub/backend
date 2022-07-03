package com.example.email.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.email.dto.UserDTO;
import com.example.email.model.User;
import com.example.email.repository.UserRepository;
import com.example.email.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo; 
	
	
	boolean login=false;
	public UserDTO save(UserDTO userDTO) {	
		
		UserDTO user = new UserDTO();
		user.setNombre(userDTO.getNombre());
		user.setPassword(userDTO.getPassword());
		
		
		
		User users= userRepo.
				findByNombreAndPassword(userDTO.getNombre(),userDTO.getPassword());
	
		
		return user;
		
	
	}
	
	
	
	
	
}

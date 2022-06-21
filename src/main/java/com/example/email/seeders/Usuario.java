package com.example.email.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.email.model.User;
import com.example.email.repository.UserRepository;

@Component
public class Usuario implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;		
	@Override
	public void run(String... args) throws Exception {
		cargarUser();
		
	}	
	private void cargarUser() {			
		if(userRepository.count()==0) {
		guardarUser();
		}
	}	
	private void guardarUser() {
		crearUser("renato@mail.com","1234");		
	}
	
	private void crearUser(String nombre,String password) {
		User user =new User(nombre, password);
		userRepository.save(user);
	}

}

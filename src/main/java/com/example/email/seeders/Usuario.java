package com.example.email.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.email.model.Rol;
import com.example.email.repository.RolRepository;

@Component
public class Usuario implements CommandLineRunner{

	
	@Autowired
	private RolRepository rolRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		crearRoles();
	}	
	
	private void crearRoles() {			
		if(rolRepo.count()==0) {			
			Rol rolAdmin =new Rol("ROLE_ADMIN");
			Rol rolUser=new Rol("ROLE_USER");
			rolRepo.save(rolAdmin);
			rolRepo.save(rolUser);			
		}
	}
	

}

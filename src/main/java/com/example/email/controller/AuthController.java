package com.example.email.controller;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.email.dto.LoginDTO;
import com.example.email.dto.RegistroDTO;
import com.example.email.model.Rol;
import com.example.email.model.Usuario;
import com.example.email.repository.RolRepository;
import com.example.email.repository.UsuarioRepository;
import com.example.email.seguridad.JWTAuthResonseDTO;
import com.example.email.seguridad.JwtTokenProvider;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	private RolRepository rolRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@Validated @RequestBody LoginDTO loginDTO ,BindingResult bindingResult ){
		 if(bindingResult.hasErrors()) {
			 throw new RuntimeException ("usuario o contraseña incorrectas");
		 }
		org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
				String token = jwtTokenProvider.generarToken(authentication);				
				JWTAuthResonseDTO j = new JWTAuthResonseDTO(token);
				 return new ResponseEntity<>(j,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<RegistroDTO> registrarUsuario(@RequestBody RegistroDTO registroDTO){
		 if(registroDTO.getEmail().isEmpty()) {			
				throw new RuntimeException("email  requrido");
			}			
		 if(registroDTO.getNombre().isEmpty()) {				
				throw new RuntimeException("Nombre  requrido");
			}
		 if(registroDTO.getPassword().isEmpty()) {			
				throw new RuntimeException("Contraseña requrida");
			}
		 
		if(usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {		
			throw new RuntimeException("Ese nombre de usuario ya existe");			
		}
				if(usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
	
			throw new RuntimeException("Ese email de usuario ya existe");
		}
		if(registroDTO.getRoles().isBlank()){
			throw new RuntimeException("ingrese algun rol");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));	
		
		 if(registroDTO.getRoles().contains("user")) {					  
			  usuario.setRoles(Collections.singleton(rolRepositorio.findByNombre("ROLE_USER").get())); 
		  }		  
		    if(registroDTO.getRoles().contains("admin")) {
		    	 usuario.setRoles(Collections.singleton(rolRepositorio.findByNombre("ROLE_ADMIN").get()));		    	
		    }	
		    
			 usuarioRepositorio.save(usuario);	
			return  ResponseEntity.status(HttpStatus.OK).build();
	
	}
	
	
}

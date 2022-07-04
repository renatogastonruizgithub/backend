package com.example.email.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<JWTAuthResonseDTO> authenticateUser(@RequestBody LoginDTO loginDTO ){
		org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//obtenemos el token del jwtTokenProvider
				String token = jwtTokenProvider.generarToken(authentication);
				
				return ResponseEntity.ok(new JWTAuthResonseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO ,BindingResult bindingResult){
		 if(bindingResult.hasErrors())
	            return new ResponseEntity<>("email mal escrito o campos mal escritos",HttpStatus.BAD_REQUEST);
		 
		if(usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
			return new ResponseEntity<>("Ese nombre de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			return new ResponseEntity<>("Ese email de usuario ya existe",HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		
		  Set<Rol> roles = new HashSet<>();	
		  
		  if(registroDTO.getRoles().contains("user")) {
			  roles.add(rolRepositorio.findByNombre("ROLE_USER").get());
		  }
		    if(registroDTO.getRoles().contains("admin")) {
		    	  roles.add(rolRepositorio.findByNombre("ROLE_ADMIN").get());		    	
		    }	
			  usuario.setRoles(roles);
			  usuarioRepositorio.save(usuario);
	
			return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	
	}
	
	
}

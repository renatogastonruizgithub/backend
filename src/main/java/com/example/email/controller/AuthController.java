package com.example.email.controller;


import java.util.Collections;
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
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO ,BindingResult bindingResult){
	
		 if(registroDTO.getEmail().isEmpty()) {
				return new ResponseEntity<>("Nombre  requrido",HttpStatus.BAD_REQUEST);
			}
		
		 if(registroDTO.getNombre().isEmpty()) {
				return new ResponseEntity<>("Nombre  requrido",HttpStatus.BAD_REQUEST);
			}
		 if(registroDTO.getPassword().isEmpty()) {
				return new ResponseEntity<>("Contraseña requrida",HttpStatus.BAD_REQUEST);
			}
		 
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
		
		  if(registroDTO.getRoles().contains("user")) {					  
			  usuario.setRoles(Collections.singleton(rolRepositorio.findByNombre("ROLE_USER").get())); 
		  }		  
		    if(registroDTO.getRoles().contains("admin")) {
		    	 usuario.setRoles(Collections.singleton(rolRepositorio.findByNombre("ROLE_ADMIN").get()));		    	
		    }	
			 usuarioRepositorio.save(usuario);	
			return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
	
	}
	
	
}

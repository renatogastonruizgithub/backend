package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.dto.EmailDTO;

import com.example.email.service.SendMailService;



@RestController
@CrossOrigin(origins = "*")
public class SendMailController {
	  @Autowired
	    private SendMailService mailService;
	  
	  @PostMapping("/send")
	  public ResponseEntity<EmailDTO> enviar(@RequestBody EmailDTO dto )
		{
		 mailService.sendEmail(dto);		  
		
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	  
}

package com.example.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.service.SendMailService;



@RestController
@CrossOrigin(origins = "*")
public class SendMailController {
	  @Autowired
	    private SendMailService mailService;
	  
	   @PostMapping("/send")
	    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

	        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
	        
	        
	        mailService.sendMail("renatogastonruiz.00@gmail.com",subject,message);
	       
	        return "mensaje enviado";
	    }
}

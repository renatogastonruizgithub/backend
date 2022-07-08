package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.email.dto.EmailDTO;

@Service
public class SendMailService {
	@Autowired
    private JavaMailSender javaMailSender;

	  public void sendEmail(EmailDTO emailDto) {
 
		  SimpleMailMessage mail = new SimpleMailMessage();
		  String message ="\n" + emailDto.getBody() + "\n Datos de contacto:"+ "\nNombre: " + emailDto.getName() + "\nResponder a: " + emailDto.getMail();
		  mail.setText(message);		 
		  mail.setSubject(emailDto.getSubject());
		  mail.setTo("renatogastonruiz.00@gmail.com");
		  mail.setFrom("renatogastonruiz.00@gmail.com");
		  
		 javaMailSender.send(mail);
	  } 
}

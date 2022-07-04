package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	@Autowired
    private JavaMailSender javaMailSender;
	
	  public void sendMail(String from, String subject, String body) {
	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setFrom(from);
	        mail.setTo("renatogastonruiz.00@gmail.com");
	        mail.setSubject(subject);
	        mail.setText(body);
	       
	        javaMailSender.send(mail);
	    }
}

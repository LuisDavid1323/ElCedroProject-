package com.Java.Cedro.Servicio;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface EmailServicio {
	
	
	
	
    void enviarEmail(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException;
    
    
    
}

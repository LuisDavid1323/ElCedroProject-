package com.Java.Cedro.SpringEmailDemo;


import com.Java.Cedro.Servicio.EmailServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements EmailServicio {

    @Autowired
    private JavaMailSender emailSender;
    @Override
    public void enviarEmail(String to, String subject, String body) {

        MimeMessage mimeMessage = this.emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
        	//mimeMessage.setContent(body,"text/html; charset=utf-8");
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            emailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Error enviando correo: " + e.getMessage() + " " + e.getCause());;
        }
    }
}

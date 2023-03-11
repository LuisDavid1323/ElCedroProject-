package com.Java.Cedro.SpringEmailDemo;


import com.Java.Cedro.Servicio.EmailServicio;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements EmailServicio {

   
    @Override
    public void enviarEmail(String to, String subject, String body) throws MessagingException, UnsupportedEncodingException { 

    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", "587");
    	
    	props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug","false");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(subject);
        msg.setContent(body,"text/html; charset=utf-8");
        msg.setFrom(new InternetAddress("maderasfinasoficial@gmail.com","Maderas Finas"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", "maderasfinasoficial@gmail.com", "qhxcnxmqlhfgljuk");
        transport.sendMessage(msg, msg.getAllRecipients());
       
    }

	@Override
	public void enviarEmail2(String to, String subject, String body)
			throws MessagingException, UnsupportedEncodingException {
		Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", "587");
    	
    	props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug","false");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(subject);
        msg.setContent(body,"text/html; charset=utf-8");
        msg.setFrom(new InternetAddress("maderasfinasoficial@gmail.com","Maderas Finas"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", "maderasfinasoficial@gmail.com", "qhxcnxmqlhfgljuk");
        transport.sendMessage(msg, msg.getAllRecipients());
       
    }
}

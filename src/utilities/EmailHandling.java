package utilities;


import javax.mail.*;
import javax.mail.internet.*;


import ca.gbc.assignment1.User;

import java.sql.Date;
import java.util.Properties;

import javax.activation.*;


public class EmailHandling extends Authenticator {
	public boolean SendEmail(User user) throws MessagingException {
		//In order to make this function to work, 
		//you have to turn on the Allow less secure app of google
		 boolean status = false;
		 String host ="smtp.gmail.com";
		 String subject = "Welcome, " + user.getFullName();
		 String message = "First Name: "+user.getFirstName() + "\n" +
				 			"Last Name: " + user.getLastName() + "\n" +
				 			"Email Address: "+user.getEmail();
		 String port = "465";
		 String email = "projectsgroup17@gmail.com";
		 String password = "Project17+";
		 
		boolean sessionDebug = false;
		// Create some properties and get the default Session.
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.transport.protocol", "smtp");
		props.setProperty("mail.transport.protocol", "smtp");     
		props.setProperty("mail.host", "smtp.gmail.com"); 
		props.put("mail.smtp.user", "projectsgroup17@gmail.com");
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.debug", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.socketFactory.port", port);
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
		
		
		EmailHandling auth = new EmailHandling();
	    Session session = Session.getInstance(props,auth);
	    session.setDebug(true);

	    MimeMessage msg = new MimeMessage(session);
	    try {
	        msg.setSubject(subject);
	        msg.setText(message);
	        msg.setFrom(new InternetAddress(email));
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

			Transport transport = session.getTransport("smtp");
			transport.connect (host, 465, email, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			status = true;
			return status;

	        } catch (AddressException e) {
	            e.printStackTrace();
	            return status;
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            return status;
	        
	}
}
}

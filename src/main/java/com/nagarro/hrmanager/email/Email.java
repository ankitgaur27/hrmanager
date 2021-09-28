package com.nagarro.hrmanager.email;

import javax.mail.*;
import javax.mail.internet.*;

import com.nagarro.hrmanager.constants.Constants;

import java.util.*;

/**
 * <h1>Email Class</h1>
 * <p>This class is used to send the OTP on email</p>
 * @author Ankit Gaur
 *
 */
public class Email {

	public static void sendEmail(String recipient, int otp) {
		Properties p = new Properties();
		
		p.put(Constants.SMTP_AUTH, Constants.SMTP_AUTH_VALUE);
		p.put(Constants.SMTP_START_TTLS, Constants.SMTP_START_TTLS_VALUE);
		p.put(Constants.SMTP_HOST, Constants.SMTP_HOST_VALUE);
		p.put(Constants.SMTP_PORT, Constants.SMTP_PORT_VALUE);

		final String sender = Constants.AUTHOR_EMAILID;
		final String password = Constants.AUTHOR_EMAIL_PASSWORD; ;

		Session s = Session.getDefaultInstance(p, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(sender, password);
			} 
		});

		Message message;
		try {
			message = prepareMessage(s, sender, recipient, otp);
			Transport.send(message); 
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		} 
	}

	private static Message prepareMessage(Session s, String sender, String recipient, int otp)
			throws AddressException, MessagingException {
		Message m = new MimeMessage(s);
		m.setFrom(new InternetAddress(sender));
		m.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		m.setSubject(Constants.EMAIL_SUBJECT);
		m.setContent(emailmessage(otp), Constants.EMAIL_TYPE);
		return m;
	}

	private static String emailmessage(int otp) {
		return "<h3 style=\"text-align: center;\">OTP</h3> <br>"
				+ "<h4 style=\"text-align: center;\">Hi, Your OTP for changing password is:</h4> <br>"
				+ "<h3 style=\"text-align: center; background-color: #ABBAEA; \">" + otp + "</h3> <br> <br> <br> "
				+ "<p>This is auto generated Mail <br>DO NOT REPLY</p>";
	}
}
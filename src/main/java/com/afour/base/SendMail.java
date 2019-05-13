package com.afour.base;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	
	static String USER_NAME = "vikas.kamble@afourtech.com"; // GMail user name (just the
	static String PASSWORD = "Vikas@A4Tech"; // GMail password
	static String RECIPIENT = "vikaskamble0083@gmail.com";
	static String[] to = GlobalData.config("To").toLowerCase().split(",");
	
	/**
	 * This method is use to send the mail
	 * @author vikas.k
	 * @since 2019-05-06
	 */

	public static void sendMail() {
		String from = USER_NAME;
		String pass = PASSWORD;
		//String[] to = { "vikaskamble0083@gmail.com", "vikaskamble8683@gmail.com" }; // list of recipient email addresses
		//System.out.println(to);
		String subject = "QA_Automation_Report_AFourTech";
		String body = "hi ....,!";		
		if (GlobalData.config("SendMailToStakeHolder").toLowerCase().equals("yes")) {
			System.out.println("===== Sending Mail to Stake Holder =====");
			SendMail.sendFromGMail(from, pass, to, subject, body);
			System.out.println("===== Mail  has been sent successfully. =====");
		} else {
			System.out.println("===== Mail not send to Stake Holder =====");
		}
	}
	
	
	/**
	 * This method is use to send the mail
	 * @param from This is first parameter to pass from mail ID
	 * @param pass This is second parameter to pass password
	 * @param to This is third parameter to pass to mail ID list.
	 * @param subject This is fourth parameter to pass Subject name
	 * @param body This is fifth parameter to pass Mail Body.
	 * @author vikas.k
	 * @throws Exception
	 *  
	 */
	
	static void sendFromGMail(final String from, final String pass, String[] to, String subject, String body) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		};
		
		Session session = Session.getInstance(props, auth);
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			message.setSubject(subject);
			message.setText(body);

			// Attachment
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("This is message body");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			//String filename = "C:/JAVA Work/ProjectDemo/Report/testReport.html";
			String filename = "C:\\JAVA Work\\POMFrameWorkDemo\\TestReport\\Test-Automaton-Report.html";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Automation Report.html");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			Transport.send(message);
			// transport.close();

		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}

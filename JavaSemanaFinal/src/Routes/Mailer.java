package Routes;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;



public class Mailer {
	public static void send(String to,String subject,String msg){

		final String user="kyscompani2@gmail.com";//change accordingly
		final String pass="@lex123456P";

		//1st step) Get the session object	
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
		 new javax.mail.Authenticator() {
		  protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication(user,pass);
		   }
		});
		//2nd step)compose message
		try {
		 MimeMessage message = new MimeMessage(session);
		 message.setFrom(new InternetAddress(user));
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		 message.setSubject(subject);
		 message.setText(msg);
		 
		 //3rd step)send message
		 Transport.send(message);

		 System.out.println("Done");

		 } catch (MessagingException e) {
			throw new RuntimeException(e);
		 }
			
		}
	
	
	public static void sendArchive(String to,String subject,String msg,String operacion){

		final String user="kyscompani2@gmail.com";//change accordingly
		final String pass="@lex123456P";

		//1st step) Get the session object	
		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
		 new javax.mail.Authenticator() {
		  protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication(user,pass);
		   }
		});
		//2nd step)compose message
		try {
		 MimeMessage message = new MimeMessage(session);
		 message.setFrom(new InternetAddress(user));
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		 message.setSubject(subject);
		 //message.setText(msg);
		 
		 
		 BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(msg);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "D://DesarrolloWEbIntegrado2020/JavaSemanaFinal/WebContent/resources/pdf/"+operacion+"reporte.pdf";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
		 //3rd step)send message
		 Transport.send(message);

		 System.out.println("Done");

		 } catch (MessagingException e) {
			throw new RuntimeException(e);
		 }
			
		}
}

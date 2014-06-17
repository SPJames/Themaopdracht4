package servlets.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegisterEmail {

	public RegisterEmail(String to, String uname, String fn, String pass) {

		final String username = "atd.probe0001@gmail.com";
		final String password = "Wachtwoord1";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Uw ATD WEB account is gereed voor gebruik");
			message.setText("Beste "
					+ fn
					+ ","
					+ "\n\nUw atd web account is gereed voor gebruik. Uw gebruikernaam is "
					+ uname + ". Uw wachtwoord is " + pass + ".\nMet vriendelijke groeten, Auto Totaal Diensten\n");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

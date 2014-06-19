package domein.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * In deze klasse wordt een mail gestuurd als een auto voor controle naar de garage moet komen
 */
public class AutoControlenEmail {

	/**
	 * In deze methode wordt de mail gestuurd. Eerst wordt ingelogd in de mailaccount
	 * vervolgens wordt de van te voren opgestelde mail verstuurd naar de meegeven ontvanger
	 * @param to het emailadres waar de mail naar toe gestuurd moet worden
	 * @param fn de naam van de ontvanger
	 */
	public AutoControlenEmail(String to, String fn) {

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
			message.setSubject("Vergeet niet uw APK - ATD");
			message.setText("Beste "
					+ fn
					+ ","
					+ "\nWe sturen deze e-mail om je eraan te herinneren dat je auto een APK-keuring nodig heeft."
					+ "\n");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

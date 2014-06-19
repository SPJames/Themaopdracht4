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
 * in deze klasse wordt een mail gestuurd als een klant een tijd niet bij de garage is geweest
 */
public class KlantHerinneringEmail {

	/**
	 * In deze methode wordt de mail gestuurd. Eerst wordt ingelogd.
	 * Vervolgens wordt de van te voren opgestelde mail gestuurd naar de megegeven ontvanger
	 * @param to het emailadres waar de mail naartoe moet
	 * @param fn de naam van de ontvanger
	 */
	public KlantHerinneringEmail(String to, String fn) {

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
			message.setSubject("Lang niet gezien! - ATD");
			message.setText("Beste "
					+ fn
					+ ","
					+ "\nWij hebben u al voor langere tijd niet gezien bij Auto Totaal Diensten."
					+ "\nVergeet niet om langs te komen voor onze speciale aanbiedingen.\n");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

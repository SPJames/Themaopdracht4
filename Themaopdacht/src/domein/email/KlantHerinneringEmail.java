package domein.email;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * deze klasse genereerd een email als de klant een tijd niet geweest is.
 */
public class KlantHerinneringEmail {

	/**
	 * Deze methode logt eerst in bij de account die de email moet sturen.
	 * De email is van te voren opgesteld en wordt gestuurd naar het door 
	 * de klant meegegeven emailadres
	 * 
	 * @param to het emailadres waar de mail naartoe gestuurd moet worden
	 * @param fn de naam van de klant
	 */
	public KlantHerinneringEmail(String to, String fn) {

		// inloggen
		final String username = "atdgarages@gmail.com";
		final String password = "Themagroep2";

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

			// de gegenereerde mail, de naam van de klant wordt ingevuld
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Lang niet gezien! - ATD");
			message.setText("Beste " + fn + ","
					+ "\nWij hebben u al voor langere tijd niet gezien bij Auto Totaal Diensten."
					+ "\nVergeet niet om langs te komen voor onze speciale aanbiedingen.\n"
					+ "\nMet vriendelijke groeten,\n\nAuto Totaal Diensten\n");
			Transport.send(message);

			Logger.getLogger("atd").info("Herrineringsmail verzonden naar de klant <"+ fn +">");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
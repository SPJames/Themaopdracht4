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
 * Deze klasse genereert een email als een klant niet op tijd betaald heeft
 */
public class NietBetaaldEmail {

	/**
	 * Deze methode logt eerst in bij de account die de mail moet sturen. De
	 * mail is van te voren opgesteld en wordt gestuurd naar het megegeven
	 * emailadres.
	 * 
	 * @param to het emailadres waar de mail naartoe moet worden gestuurd
	 * @param fn de naam van de ontvangende klant
	 */
	public NietBetaaldEmail(String to, String fn) {

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
			// de gegenereerde email. de naam van de klant wordt ingevuld
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("U heeft nog niet betaald - ATD");
			message.setText("Beste "
					+ fn
					+ ","
					+ "\nWij hebben gemerkt dat u nog niet heeft betaald."
					+ "\nBetalingen dienen uiterlijk binnen 90 dagen te worden overgemaakt naar Auto Totaal Diensten."
					+ "\nMet vriendelijke groeten,\n\nAuto Totaal Diensten\n");

			Transport.send(message);

			Logger.getLogger("atd").info("Niet betaald mail verzonden naar de klant <"+ fn +">");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

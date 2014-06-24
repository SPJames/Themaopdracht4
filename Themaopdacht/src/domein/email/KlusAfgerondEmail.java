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
 * In deze klasse wordt een email gegenereert als een klus is afgerond
 */
public class KlusAfgerondEmail {

	/**
	 * Er wordt ingelogd op het adres waarvandaan de mail gestuurd gaat worden.
	 * Een van te voren opgestelde mail wordt gestuurd naar de meegegeven klant.
	 * 
	 * @param to het adres waar de mail naartoe gestuurd moet worden
	 * @param fn de naam van de ontvanger van de email
	 */
	public KlusAfgerondEmail(String to, String fn) {

		//inloggen
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
			//mail genereren, de klantnaam wordt ingevuld
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Uw auto staat klaar - ATD");
			message.setText("Beste " + fn + ","
					+ "\nUw auto staat klaar om afgehaald te worden."
					+ "\nMet vriendelijke groeten,\n\nAuto Totaal Diensten\n");

			Transport.send(message);

			Logger.getLogger("atd").info("Auto klaar mail verzonden naar de klant <"+ fn +">");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

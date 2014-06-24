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
 * In deze klasse wordt een email gestuurd als een klant zich geregistreerd heeft
 */
public class RegisterEmail {

	/**
	 * Er wordt ingelogd in het adres waarvandaan de mail gestuurd gaat worden.
	 * Een van te voren opgestelde email wordt gestuurd naar het door de klant
	 * opgegeven emailadres
	 * 
	 * @param to het emailadres waar de mail naartoe gestuurd wordt
	 * @param uname de gebruikersnaam van de klant
	 * @param fn de naam van de klant
	 * @param pass het wachtwoord van de klant
	 */
	public RegisterEmail(String to, String uname, String fn, String pass) {

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

			//de mail wordt gegenereert de naam van de klant, de username van de klant en het wachtwoord
			//wordt meegegeven
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(to));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject("Uw ATD WEB account is gereed voor gebruik");
			message.setText("Beste " + fn + ","
					+ "\n\nUw atd web account is gereed voor gebruik. Uw gebruikernaam is "
					+ uname + ". Uw wachtwoord is " + pass 
					+ "\nMet vriendelijke groeten,\n\nAuto Totaal Diensten\n");
			Transport.send(message);

			Logger.getLogger("atd").info("Registratie email verzonden naar de klant <"+ fn +">");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
package domein.klusbeheer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import domein.klantenbinding.Auto;
/**
 * deze klasse beheert de parkeerplaats
 * welke plekken er vanaf wanneer door welke auto bezet zijn
 */
public class Parkeerplaats {
	private Auto auto;
	private Calendar reseveringsDatum;

	private Calendar cal = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * deze methode maakt de parkeerplaats aan en geeft een auto en de huidige datum mee
	 * @param a de meegegeven auto die wil parkeren
	 */
	public Parkeerplaats(Auto a) {
		setAuto(a);
		setReseveringsDatum(cal);
	}

	/**
	 * deze methode vraagt de auto op
	 * @return de auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * deze methode wijzigt de auto
	 * @param auto de nieuwe auto
	 */
	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	/**
	 * deze methode vraagt de reserveringsdatum op
	 * @return de reserveringsdatum
	 */
	public String getReseveringsDatum() {
		return df.format(reseveringsDatum);
	}

	/**
	 * deze methode verandert de reserveringsdatum
	 * @param reseveringsDatum de nieuwe reserveringsdatum
	 */
	public void setReseveringsDatum(Calendar reseveringsDatum) {
		this.reseveringsDatum = reseveringsDatum;
	}
}

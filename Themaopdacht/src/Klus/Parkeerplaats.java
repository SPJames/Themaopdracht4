package Klus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import klantenbinding.Auto;

public class Parkeerplaats {
	private Auto auto;
	private Calendar reseveringsDatum;

	private Calendar cal = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public Parkeerplaats(Auto a) {
		setAuto(a);
		setReseveringsDatum(cal);
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getReseveringsDatum() {
		return df.format(reseveringsDatum);
	}

	public void setReseveringsDatum(Calendar reseveringsDatum) {
		this.reseveringsDatum = reseveringsDatum;
	}
}

package Klusbeheer;

import financien.DienstType;

public class Klus {
	private int klusnummer;
	private String beschrijving;
	private String werknemer;
	private int aantalOnderdelen;
	private DienstType hetType;

	public Klus(int kn, String b, String wn) {
		klusnummer = kn;
		beschrijving = b;
		werknemer = wn;
	}

	public int getKlusNummer() {
		return klusnummer;
	}

	public void setKlusNummer(int kn) {
		klusnummer = kn;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String b) {
		beschrijving = b;
	}

	public int getAantalOnderdelen() {
		return aantalOnderdelen;
	}

	public void setAantalOnderdelen(int aO) {
		aantalOnderdelen = aO;
	}

	public void setHetType(DienstType dt) {
		hetType = dt;
	}

	public DienstType getHetType() {
		return hetType;
	}

	public String getWerknemer() {
		return werknemer;
	}

	public void setWerknemer(String wn) {
		werknemer = wn;
	}

	public String toString() {
		String s = "" + getKlusNummer();
		return s;
	}
}

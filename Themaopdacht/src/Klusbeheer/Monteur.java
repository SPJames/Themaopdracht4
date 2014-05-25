package Klusbeheer;

import java.io.FileWriter;
import java.io.IOException;

public class Monteur {
	private String naam;
	private String password;
	private Klus deKlus;
	private static int id = 1;

	public static int getId() {
		return id;
	}

	public Monteur(String nm, String pw) {
		setNaam(nm);
		setPassword(pw);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Klus getDeKlus() {
		return deKlus;
	}

	public void setDeKlus(Klus dK) {
		deKlus = dK;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void schrijfWeg(String[] monteur) throws IOException{
		FileWriter fw = new FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/monteur/monteurs.dat",true);

		fw.write("\n" + id++ + " " + monteur[0] + ":" + monteur[1] + ";");
		fw.flush();
		fw.close();
	}

	public String toString() {
		String s = "" + getNaam();
		return s;
	}
}

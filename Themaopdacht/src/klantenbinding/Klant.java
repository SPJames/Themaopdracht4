package klantenbinding;

//import java.io.FileWriter;
//import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Klant {
	private String naam;
	private String adres;
	private String postcode;
	private String email;
	private String username;
	private String password;

	private Calendar laatstBezocht;
	private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static int getal = 1;
	private int id;

	public Klant(String nm, String ad, String pc, String em, String un, String pw) {
		setNaam(nm);
		setAdres(ad);
		setPostcode(pc);
		setEmail(em);
		setUsername(un);
		setPassword(pw);
		id = getal++;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNaam() {
		return naam;
	}

	public void setNaam(String nm) {
		naam = nm;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String ad) {
		adres = ad;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String pc) {
		postcode = pc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String em) {
		email = em;
	}

	public String getLaatstBezocht() {
		if (laatstBezocht != null) {
			return df.format(laatstBezocht.getTime());
		} else {
			String s = "Geen datum beschikbaar";
			return s;
		}
	}
	
//	public void schrijfWeg(String[] userinfo) throws IOException{
//		FileWriter fw = new FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/users.dat", true);
//		
//		fw.write("\n"+ id++ +" "+userinfo[0]+":"+userinfo[2]+";"+userinfo[1]+" "+userinfo[4]+" "+userinfo[6]+" "+userinfo[7]);
//		fw.flush();
//		fw.close();
//	}

	public int getId() {
		return id;
	}


	public void setLaatstBezocht(Calendar nd) {
		laatstBezocht = nd;
	}

	public ArrayList<Auto> getAlleAutos() {
		return alleAutos;
	}

	public void voegAutoToe(Auto nwA) {
		if (!heeftAuto(nwA.getKenteken())) { // auto kan alleen toegevoegd
												// worden als deze nog niet
												// geregistreerd is
			alleAutos.add(nwA);
		}
	}

	public boolean heeftAuto(String kt) {
		boolean result = false;
		if (zoekAuto(kt) != null) {
			result = true;
		}
		return result;
	}

	public Auto zoekAuto(String kt) {
		Auto result = null;
		for (Auto a : alleAutos) {
			if (a.getKenteken().equals(kt)) {
				result = a;
			}
		}
		return result;
	}

	public boolean verwijderAuto(Auto exA) { // auto kan alleen verwijdert
												// worden als deze geregistreerd
												// is
		boolean result = false;
		if (heeftAuto(exA.getKenteken())) {
			result = true;
			alleAutos.remove(exA);
		}
		return result;
	}

	public int aantalAutos() {
		if (alleAutos.size() != 0) {
			return alleAutos.size();
		} else {
			return 0;
		}
	}

/*	public String toString() {
		String s = getNaam() + "";
		return s;
	}*/
}
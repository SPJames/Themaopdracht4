package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import klantenbinding.Klant;

public class Database {
	private static int klantid = 1;

	// lees data in
	public void leesUsersIn(ArrayList<Klant> Users) throws IOException {
		
		Klant k = null;
		//int id = 0;
		String naam = null;
		String adres = null;
		String postcode = null;
		String email= null;
		String username= null;
		String password= null;

		BufferedReader br = new BufferedReader(new FileReader("C:/apache-tomcat-8.0.5/webapps/AccountSysteem/afspraken.dat"));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.length() > 0) {
				int endID = str.indexOf(" ");
				int endUsername = str.indexOf(":");
				int endPassword = str.indexOf(";");
				int endRealname = str.indexOf("'");
				int endEmail = str.indexOf(",");
				int endAdres = str.indexOf(".");
				int endPostcode = str.indexOf("|");
				//int end = str.indexOf("/");

				//id = Integer.parseInt(str.substring(0, (endID)));
				username = str.substring((endID + 1), (endUsername));
				password = str.substring((endUsername + 1), (endPassword));
				naam = str.substring((endPassword + 1), (endRealname));
				email = str.substring((endRealname + 1), (endEmail));
				adres = str.substring((endEmail + 1), (endAdres));
				postcode = str.substring((endAdres + 1), (endPostcode));
			}
		}
		br.close();
		
		k = new Klant(naam, adres, postcode, email, username, password);
		Users.add(k);
	}

	public void leesMonteursIn() {

	}

	public void leesKlussenIn() {

	}

	// schrijf data weg
	public void schrijfUserWeg(String[] userinfo) throws IOException {
		FileWriter fw = new FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/users.dat", true);

		fw.write("\n" + klantid++ + " " + userinfo[0]/*username*/ + ":" + userinfo[2]/*password*/ + ";"
				+ userinfo[1]/*realname*/ + "'" + userinfo[4]/*email*/ + "," + userinfo[6]/*adress*/ + "."
				+ userinfo[7]/*postcode*/ + "|");
		fw.flush();
		fw.close();
	}

	public void schrijfMonteurWeg() {

	}

	public void schrijfKlusWeg() {

	}
}

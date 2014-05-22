package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import klantenbinding.Auto;
import klantenbinding.Klant;

public class Database {
	private static int userid = 1;

	// lees data in
	public static void leesUsersIn(ArrayList<Klant> Users) throws IOException {
		
//		String naam = null;
//		String adres = null;
//		String postcode = null;
//		String email= null;
//		String username= null;
//		String password= null;

		
		//syntax in file moet correct zijn, anders ListenerErrors
		BufferedReader br = new BufferedReader(new FileReader("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/users.dat"));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.length() > 0) {
				int endID = str.indexOf(" ");
				int endUsername = str.indexOf(":");
				int endPassword = str.indexOf(";");
				int endRealname = str.indexOf("'");
				int endEmail = str.indexOf(",");
				int endAdres = str.indexOf("/");
				int endPostcode = str.indexOf("|");

				String username = str.substring((endID + 1), (endUsername));
				String password = str.substring((endUsername + 1), (endPassword));
				String naam = str.substring((endPassword + 1), (endRealname));
				String email = str.substring((endRealname + 1), (endEmail));
				String adres = str.substring((endEmail + 1), (endAdres));
				String postcode = str.substring((endAdres + 1), (endPostcode));
				
				Klant k = new Klant(naam, adres, postcode, email, username, password);
				Users.add(k);
			}
		}
		br.close();	
	}
	
	public static void leesAutosIn(ArrayList<Auto> Autos) throws IOException {
		Auto a = null;
		//int id = 0;
		String kenteken = null;
		String merk = null;
		String id = null;

		BufferedReader br = new BufferedReader(new FileReader("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/autos.dat"));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.length() > 0) {
				int endKenteken = str.indexOf(" ");
				int endMerk = str.indexOf(":");
				int endId = str.indexOf(";");

				kenteken = str.substring(0, (endKenteken));
				merk = str.substring((endKenteken + 1), (endMerk));
				id = str.substring((endMerk + 1), (endId));
				
				a = new Auto(kenteken, merk, id);
				Autos.add(a);
			}
			
		}
		br.close();
	}
	
	public static void leesMonteursIn() {

	}

	public static void leesKlussenIn() {

	}

	// schrijf data weg
	public static void schrijfUserWeg(String[] userinfo) throws IOException {
		FileWriter fw = new FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/users.dat", true);

		fw.write(userid++ + " " + userinfo[0]/*username*/ + ":" + userinfo[2]/*password*/ + ";"
				+ userinfo[1]/*realname*/ + "'" + userinfo[4]/*email*/ + "," + userinfo[6]/*adress*/ + "/"
				+ userinfo[7]/*postcode*/ + "|" + "\n");
		fw.flush();
		fw.close();
	}

	public static void schrijfAutoWeg(String kt, String merk, String id) throws IOException {
		FileWriter fw = new FileWriter("C:/apache-tomcat-8.0.5/webapps/Themaopdracht4/users.dat", true);

		fw.write("\n"+ kt + ";" + merk + ":" + id + "|");
		fw.flush();
		fw.close();
	}
	
	public static void schrijfMonteurWeg() {

	}

	public static void schrijfKlusWeg() {

	}
}

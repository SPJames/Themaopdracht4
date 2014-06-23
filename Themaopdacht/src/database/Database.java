package database;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import domein.financien.Factuur;
import domein.klantenbinding.Auto;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Monteur;
import domein.klusbeheer.Parkeerplaats;
import domein.klusbeheer.Weekplanning;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

/**
 * in deze klasse worden de gegevens van het systeem weggeschreven en opgehaald
 */
public class Database {
	private File currentDirectory = new File(new File(".").getAbsolutePath()).getParentFile();
	
	private String directory = currentDirectory.getParent() + "/webapps/atd/data/data.dat";
	
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	/**
	 * Deze methode geeft de locatie van de data.dat file
	 * @return directory
	 * @throws IOException 
	 */
	public String getPath() throws IOException{
		return directory;
	}
	
	//check of file leeg is
	/**
	 * Check of de data.dat file leeg is
	 * 
	 * @return boolean
	 */
	public boolean isLeeg() throws IOException {
		boolean result = false;
		//String directory = locatie.toString(); //currentDirectory.getCanonicalPath() + "\\..\\webapps\\atd\\data\\data.dat";
		
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(directory));     
		if (br.readLine() == null) {
		    result = true;
		}
		
		return result;
	}
	
	// lees data in
	/**
	 * lees de gegevens in uit data.dat.
	 * 
	 * @return HashMap<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> leesIn() throws IOException{
		//String directory = locatie.toString(); //currentDirectory.getCanonicalPath() + "\\..\\webapps\\atd\\data\\data.dat";
		
		HashMap<String, Object> map = null;
		
		FileInputStream fin = new FileInputStream(directory);
		ObjectInputStream ois = new ObjectInputStream(fin);
		try {
			map = (HashMap<String, Object>) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database error met file uitlezen");
		}
		
		return map;
	}
	//schrijf data weg
	/**
	 * Schrijf gegevens weg naar data.dat
	 * 
	 * @param kla ArrayList van klanten
	 * @param mo ArrayList van monteurs
	 * @param klu ArrayList van klussen
	 * @param au ArrayList van auto's
	 * @param pa array van parkeerplaatsen
	 * @param on ArrayList van onderdelen
	 * @param fa ArrayList van facturen
	 * @param br ArrayList van brandstof
	 * @param pl weekplanning Object
	 */
	public void schrijfWeg(ArrayList<Klant> kla, ArrayList<Monteur> mo, ArrayList<Klus> klu, ArrayList<Auto> au, Parkeerplaats[] pa, ArrayList<Onderdeel> on, ArrayList<Factuur> fa, ArrayList<Brandstof> br, Weekplanning pl) throws IOException{
		data.put("List", (Object) kla);
		data.put("List2", (Object) mo);
		data.put("List3", (Object) klu);
		data.put("List4", (Object) au);
		data.put("List5", (Object) pa);
		data.put("List6", (Object) on);
		data.put("List7", (Object) fa);
		data.put("List8", (Object) br);
		data.put("planning", (Object) pl);
		
		//String directory = locatie.toString(); //currentDirectory.getCanonicalPath() + "\\..\\webapps\\atd\\data\\data.dat";
		File f = new File(directory);
		if(f.exists() && !f.isDirectory()) { 
			FileOutputStream fos = new FileOutputStream(directory);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		      oos.writeObject(data);
		      oos.close();
		}
	}
}
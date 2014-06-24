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
 * In deze klasse worden de gegevens van het systeem weggeschreven en opgehaald
 */
public class Database {
	private File currentDirectory = new File(new File(".").getAbsolutePath()).getParentFile();
	private String directory = currentDirectory.getParent() + "/webapps/atd/data/data.dat";
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	/**
	 * Deze methode controleert of de data.dat file leeg is
	 * 
	 * @return true, als de file leeg is, false als de file niet leeg is
	 */
	public boolean isLeeg() throws IOException {
		boolean result = false;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(directory));     
		if (br.readLine() == null) {
		    result = true;
		}
		
		return result;
	}
	
	/**
	 * Deze methode leest de gegevens in uit data.dat.
	 * 
	 * @return HashMap<String, Object>, de hashmap met alle opgeslagen gegevens
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> leesIn() throws IOException{
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
	
	/**
	 * Deze methode schrijft gegevens weg naar data.dat
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
	public void schrijfWeg(ArrayList<Klant> kla, ArrayList<Monteur> mo, ArrayList<Klus> klu, ArrayList<Auto> au, Parkeerplaats[] pa, ArrayList<Onderdeel> on, ArrayList<Factuur> fa, ArrayList<Brandstof> br, Weekplanning pl, HashMap<String, Integer> id) throws IOException{
		data.put("List", (Object) kla);
		data.put("List2", (Object) mo);
		data.put("List3", (Object) klu);
		data.put("List4", (Object) au);
		data.put("List5", (Object) pa);
		data.put("List6", (Object) on);
		data.put("List7", (Object) fa);
		data.put("List8", (Object) br);
		data.put("planning", (Object) pl);
		data.put("ids", (Object) id);

		File f = new File(directory);
		if(f.exists() && !f.isDirectory()) { 
			FileOutputStream fos = new FileOutputStream(directory);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		      oos.writeObject(data);
		      oos.close();
		}
	}
}
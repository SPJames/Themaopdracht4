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
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

public class Database {
	private File currentDirectory = new File(new File(".").getAbsolutePath());
	
	private HashMap<Integer, Object> data = new HashMap<Integer, Object>();
	
	private ArrayList<Klant> list;
	private ArrayList<Monteur> list2;
	private ArrayList<Klus> list3;
	private ArrayList<Auto> list4;
	private Parkeerplaats[] list5;
	private ArrayList<Onderdeel> list6;
	private ArrayList<Factuur> list7;
	private ArrayList<Brandstof> list8;

	// lees data in
	public HashMap<Integer, Object> leesIn() throws IOException{
		String directory = currentDirectory.getCanonicalPath() + "/../../../data/data.dat";
		
		HashMap<Integer, Object> map = null;
		
		return map;
	}
	public void schrijfWeg(ArrayList<Klant> list, ArrayList<Monteur> list2, ArrayList<Klus> list3, ArrayList<Auto> list4, Parkeerplaats[] list5, ArrayList<Onderdeel> list6, ArrayList<Factuur> list7, ArrayList<Brandstof> list8) throws IOException{
		data.put(1, (Object) list);
		data.put(2, (Object) list2);
		data.put(3, (Object) list3);
		data.put(4, (Object) list4);
		data.put(5, (Object) list5);
		data.put(6, (Object) list6);
		data.put(7, (Object) list7);
		data.put(8, (Object) list8);
		
		String directory = currentDirectory.getCanonicalPath() + "/../../../data/data.dat";
		
		FileOutputStream fos = new FileOutputStream(directory);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(data);
	      oos.close();
	}
}
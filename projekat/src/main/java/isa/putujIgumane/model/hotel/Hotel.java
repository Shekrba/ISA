package isa.putujIgumane.model.hotel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import isa.putujIgumane.model.ProsecnaOcena;

public class Hotel {
	private String naziv;
	private String adresa;
	private String opis; 
	private HashMap<String, Integer> cenovnikUsluga;
	private ArrayList<Soba> sobe;
	private ProsecnaOcena prosecnaOcena;
	private HashMap<Date, Double> prihodi;
	
	public Hotel(String naziv, String adresa, String opis) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.opis = opis;
		this.cenovnikUsluga = new HashMap<>();
		this.sobe = new ArrayList<>();
		this.prosecnaOcena = new ProsecnaOcena();
		this.prihodi = new HashMap<>();
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public HashMap<String, Integer> getCenovnikUsluga() {
		return cenovnikUsluga;
	}
	public void setCenovnikUsluga(HashMap<String, Integer> cenovnikUsluga) {
		this.cenovnikUsluga = cenovnikUsluga;
	}
	public ArrayList<Soba> getSobe() {
		return sobe;
	}
	public void setSobe(ArrayList<Soba> sobe) {
		this.sobe = sobe;
	}
	public ProsecnaOcena getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(ProsecnaOcena prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	public HashMap<Date, Double> getPrihodi() {
		return prihodi;
	}
	public void setPrihodi(HashMap<Date, Double> prihodi) {
		this.prihodi = prihodi;
	}
}

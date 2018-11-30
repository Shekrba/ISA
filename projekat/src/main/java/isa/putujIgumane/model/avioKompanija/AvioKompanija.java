package isa.putujIgumane.model.avioKompanija;

import java.util.ArrayList;

import isa.putujIgumane.model.ProsecnaOcena;

public class AvioKompanija {
	private String naziv;
	private String adresa;
	private String promotivniOpis;
	private ArrayList<String> destinacije;
	private ArrayList<Let> letovi;
	private ArrayList<Karta> karateSaPopustima;
	private ArrayList<Segment> segmenti;
	private ProsecnaOcena prosecnaOcena;
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
	public String getPromotivniOpis() {
		return promotivniOpis;
	}
	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}
	public ArrayList<String> getDestinacije() {
		return destinacije;
	}
	public void setDestinacije(ArrayList<String> destinacije) {
		this.destinacije = destinacije;
	}
	public ArrayList<Let> getLetovi() {
		return letovi;
	}
	public void setLetovi(ArrayList<Let> letovi) {
		this.letovi = letovi;
	}
	public ArrayList<Karta> getKarateSaPopustima() {
		return karateSaPopustima;
	}
	public void setKarateSaPopustima(ArrayList<Karta> karateSaPopustima) {
		this.karateSaPopustima = karateSaPopustima;
	}
	public ArrayList<Segment> getSegmenti() {
		return segmenti;
	}
	public void setSegmenti(ArrayList<Segment> segmenti) {
		this.segmenti = segmenti;
	}
	public ProsecnaOcena getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(ProsecnaOcena prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
}

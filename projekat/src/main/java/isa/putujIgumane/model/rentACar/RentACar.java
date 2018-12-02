package isa.putujIgumane.model.rentACar;

import java.util.ArrayList;

import isa.putujIgumane.model.ProsecnaOcena;

public class RentACar {
	private String nazivServisa;
	private String adresaServisa;
	private String promotivniOpis;
	private ArrayList<String> filijale;
	private ArrayList<Vozilo> listaVozila;
	private ProsecnaOcena prosecnaOcenaServisa;
	
	public RentACar(String nazivServisa, String adresaServisa, String promotivniOpis, ArrayList<String> filijale,
			ArrayList<Vozilo> listaVozila, ProsecnaOcena prosecnaOcenaServisa) {
		super();
		this.nazivServisa = nazivServisa;
		this.adresaServisa = adresaServisa;
		this.promotivniOpis = promotivniOpis;
		this.filijale = filijale;
		this.listaVozila = listaVozila;
		this.prosecnaOcenaServisa = prosecnaOcenaServisa;
	}

	public RentACar() {
		super();
		this.nazivServisa = "";
		this.adresaServisa = "";
		this.promotivniOpis = "";
		this.filijale = new ArrayList<String>();
		this.listaVozila = new ArrayList<Vozilo>();
		this.prosecnaOcenaServisa.setBrojOcena(0);
		this.prosecnaOcenaServisa.setTrenutnaOcena(0);
	}

	public String getNazivServisa() {
		return nazivServisa;
	}

	public void setNazivServisa(String nazivServisa) {
		this.nazivServisa = nazivServisa;
	}

	public String getAdresaServisa() {
		return adresaServisa;
	}

	public void setAdresaServisa(String adresaServisa) {
		this.adresaServisa = adresaServisa;
	}

	public String getPromotivniOpis() {
		return promotivniOpis;
	}

	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}

	public ArrayList<String> getFilijale() {
		return filijale;
	}

	public void setFilijale(ArrayList<String> filijale) {
		this.filijale = filijale;
	}

	public ArrayList<Vozilo> getListaVozila() {
		return listaVozila;
	}

	public void setListaVozila(ArrayList<Vozilo> listaVozila) {
		this.listaVozila = listaVozila;
	}

	public ProsecnaOcena getProsecnaOcenaServisa() {
		return prosecnaOcenaServisa;
	}

	public void setProsecnaOcenaServisa(ProsecnaOcena prosecnaOcenaServisa) {
		this.prosecnaOcenaServisa = prosecnaOcenaServisa;
	}
	
}

package isa.putujIgumane.dto.rentacar;

import java.sql.Date;

import isa.putujIgumane.model.korisnik.Rezervacija;
import isa.putujIgumane.model.rentACar.RezervacijaVozila;

public class RezervacijaVozilaDTO {
	
	private Long id;
	private VoziloDTO vozilo;
	private Date datum;
	private boolean otkazano;
	private Date datumDolaska;
	private Date datumOdlaska;
	private double ukupnaCena;
	private Rezervacija rezervacija;
	
	
	public RezervacijaVozilaDTO(RezervacijaVozila r) {
		super();
		this.id = r.getId();
		this.datum = r.getDatum();
		this.otkazano = r.isOtkazano();
		this.datumDolaska = r.getDatumDolaska();
		this.datumOdlaska = r.getDatumOdlaska();
		this.ukupnaCena = r.getUkupnaCena();
		this.rezervacija = r.getRezervacija();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public VoziloDTO getVozilo() {
		return vozilo;
	}


	public void setVozilo(VoziloDTO vozilo) {
		this.vozilo = vozilo;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public boolean isOtkazano() {
		return otkazano;
	}


	public void setOtkazano(boolean otkazano) {
		this.otkazano = otkazano;
	}


	public Date getDatumDolaska() {
		return datumDolaska;
	}


	public void setDatumDolaska(Date datumDolaska) {
		this.datumDolaska = datumDolaska;
	}


	public Date getDatumOdlaska() {
		return datumOdlaska;
	}


	public void setDatumOdlaska(Date datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}


	public double getUkupnaCena() {
		return ukupnaCena;
	}


	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}


	public Rezervacija getRezervacija() {
		return rezervacija;
	}


	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	
	
}

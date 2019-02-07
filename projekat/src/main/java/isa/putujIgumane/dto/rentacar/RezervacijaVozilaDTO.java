package isa.putujIgumane.dto.rentacar;

import java.sql.Date;
import java.time.LocalDate;

import isa.putujIgumane.model.korisnik.Rezervacija;
import isa.putujIgumane.model.rentACar.RezervacijaVozila;

public class RezervacijaVozilaDTO {
	
	private Long id;
	private VoziloDTO vozilo;
	private LocalDate datum;
	private boolean otkazano;
	private LocalDate datumDolaska;
	private LocalDate datumOdlaska;
	private double ukupnaCena;
	private Rezervacija rezervacija;
	
	
	public RezervacijaVozilaDTO() {
		
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


	public LocalDate getDatum() {
		return datum;
	}


	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}


	public boolean isOtkazano() {
		return otkazano;
	}


	public void setOtkazano(boolean otkazano) {
		this.otkazano = otkazano;
	}


	public LocalDate getDatumDolaska() {
		return datumDolaska;
	}


	public void setDatumDolaska(LocalDate datumDolaska) {
		this.datumDolaska = datumDolaska;
	}


	public LocalDate getDatumOdlaska() {
		return datumOdlaska;
	}


	public void setDatumOdlaska(LocalDate datumOdlaska) {
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

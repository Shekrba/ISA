package isa.putujIgumane.dto.hotel;

import java.sql.Date;

import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Rezervacija;

public class RezervacijaSobeDTO {
	
	private Long id;
	
	private Soba soba;
	
	private Date datum;
	
	private boolean otkazano;
	
	private Date datumDolaska;
	
	private Date datumOdlaska;
	
	private double ukupnaCena;
	
	private Rezervacija rezervacija;
	
	
	public RezervacijaSobeDTO(RezervacijaSobe rs) {
		super();
		this.id = rs.getId();
		this.soba = rs.getSoba();
		this.datum = rs.getDatum();
		this.otkazano = rs.isOtkazano();
		this.datumDolaska = rs.getDatumDolaska();
		this.datumOdlaska = rs.getDatumOdlaska();
		this.ukupnaCena = rs.getUkupnaCena();
		this.rezervacija = rs.getRezervacija();
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Soba getSoba() {
		return soba;
	}
	public void setSoba(Soba soba) {
		this.soba = soba;
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

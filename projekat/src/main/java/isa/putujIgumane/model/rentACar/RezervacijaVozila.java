package isa.putujIgumane.model.rentACar;

import java.sql.Date;


public class RezervacijaVozila {
	
	private Vozilo vozilo;
	private Date datum;
	private boolean otkazano;
	private Date datumDolaska;
	private Date datumOdlaska;
	private double ukupnaCena;
	
	
	public RezervacijaVozila(Vozilo vozilo, Date datum, boolean otkazano, Date datumDolaska, Date datumOdlaska,
			double ukupnaCena) {
		super();
		this.vozilo = vozilo;
		this.datum = datum;
		this.otkazano = otkazano;
		this.datumDolaska = datumDolaska;
		this.datumOdlaska = datumOdlaska;
		this.ukupnaCena = ukupnaCena;
	}


	public Vozilo getVozilo() {
		return vozilo;
	}


	public void setVozilo(Vozilo vozilo) {
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
}

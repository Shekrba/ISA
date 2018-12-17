package isa.putujIgumane.model.hotel;

import java.sql.Date;

public class RezervacijaSobe {
	private Soba soba;
	private Date datum;
	private boolean otkazano;
	private Date datumDolaska;
	private Date datumOdlaska;
	private double ukupnaCena;
	
	
	
	public RezervacijaSobe(Soba soba, Date datum, boolean otkazano, Date datumDolaska, Date datumOdlaska,
			double ukupnaCena) {
		super();
		this.soba = soba;
		this.datum = datum;
		this.otkazano = otkazano;
		this.datumDolaska = datumDolaska;
		this.datumOdlaska = datumOdlaska;
		this.ukupnaCena = ukupnaCena;
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
	
	
	
}

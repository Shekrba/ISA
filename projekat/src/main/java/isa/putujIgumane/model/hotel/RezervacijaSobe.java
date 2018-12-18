package isa.putujIgumane.model.hotel;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class RezervacijaSobe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Soba soba;
	
	@Column(name = "datum", unique = false, nullable = false)
	private Date datum;
	
	@Column(name = "otkazano", unique = false, nullable = false)
	private boolean otkazano;
	
	@Column(name = "datumDolaska", unique = false, nullable = false)
	private Date datumDolaska;
	
	@Column(name = "datumOdlaska", unique = false, nullable = false)
	private Date datumOdlaska;
	
	@Column(name = "ukupnaCena", unique = false, nullable = false)
	private double ukupnaCena;
	
	
	
	
	public RezervacijaSobe(Long id, Soba soba, Date datum, boolean otkazano, Date datumDolaska, Date datumOdlaska,
			double ukupnaCena) {
		super();
		this.id = id;
		this.soba = soba;
		this.datum = datum;
		this.otkazano = otkazano;
		this.datumDolaska = datumDolaska;
		this.datumOdlaska = datumOdlaska;
		this.ukupnaCena = ukupnaCena;
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
	
	
	
}

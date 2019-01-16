package isa.putujIgumane.model.hotel;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatusSobe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Soba soba;
	
	@Column(name = "datum", unique = false, nullable = false)
	private Date datum;
	
	@Column(name = "zauzeto", unique = false, nullable = false)
	private boolean zauzeto;
	
	@Column(name = "cena", unique = false, nullable = false)
	private double cena;
	
	@Column(name = "popust", unique = false, nullable = false)
	private short popust;

	
	public StatusSobe() {
		super();
	}

	public StatusSobe(Long id, Soba soba, Date datum, boolean zauzeto, double cena, short popust) {
		super();
		this.id = id;
		this.soba = soba;
		this.datum = datum;
		this.zauzeto = zauzeto;
		this.cena = cena;
		this.popust = popust;
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

	public boolean isZauzeto() {
		return zauzeto;
	}

	public void setZauzeto(boolean zauzeto) {
		this.zauzeto = zauzeto;
	}

	public short getPopust() {
		return popust;
	}

	public void setPopust(short popust) {
		this.popust = popust;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

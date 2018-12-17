package isa.putujIgumane.model.rentACar;

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
public class StatusVozila {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Vozilo vozilo;
	
	@Column(name = "cena", unique = false, nullable = false)
	private double cena;
	
	@Column(name = "voziloJeIznajmljeno", unique = false, nullable = false)
	private boolean voziloJeIznajmljeno;
	
	@Column(name = "datum", unique = false, nullable = false)
	private Date datum;
	
	@Column(name = "popust", unique = false, nullable = false)
	private short popust;
	
	
	public StatusVozila(Long id, Vozilo vozilo, double cena, boolean voziloJeIznajmljeno, Date datum, short popust) {
		super();
		this.id = id;
		this.vozilo = vozilo;
		this.cena = cena;
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
		this.datum = datum;
		this.popust = popust;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Vozilo getVozilo() {
		return vozilo;
	}


	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public boolean isVoziloJeIznajmljeno() {
		return voziloJeIznajmljeno;
	}


	public void setVoziloJeIznajmljeno(boolean voziloJeIznajmljeno) {
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public short getPopust() {
		return popust;
	}


	public void setPopust(short popust) {
		this.popust = popust;
	}
}

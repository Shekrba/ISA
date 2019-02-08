package isa.putujIgumane.model.avioKompanija;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import isa.putujIgumane.model.korisnik.Rezervacija;

@Entity
public class Karta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "kupljena", unique = false, nullable = false)
	private Boolean kupljena;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Sediste sediste;
	
	@Column(name = "popust", unique = false, nullable = false)
	private Short popust;
	
	@Column(name = "cena", unique = false, nullable = false)
	private Double cena;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Rezervacija rezervacija;
	
	@Version
	private long version;
	
	
	public Karta() {
		
	}
	
	
	
	public long getVersion() {
		return version;
	}



	public void setVersion(long version) {
		this.version = version;
	}



	public Double getCena() {
		return cena;
	}



	public void setCena(Double cena) {
		this.cena = cena;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getKupljena() {
		return kupljena;
	}

	public void setKupljena(Boolean kupljena) {
		this.kupljena = kupljena;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public Short getPopust() {
		return popust;
	}

	public void setPopust(Short popust) {
		this.popust = popust;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	
	
	
	
}

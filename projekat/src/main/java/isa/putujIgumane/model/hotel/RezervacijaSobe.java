package isa.putujIgumane.model.hotel;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import isa.putujIgumane.model.korisnik.Rezervacija;

@Entity
public class RezervacijaSobe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Soba soba;
	
	@Column(name = "datum", unique = false, nullable = false)
	private LocalDate datum;
	
	@Column(name = "otkazano", unique = false, nullable = false)
	private boolean otkazano;
	
	@Column(name = "datumDolaska", unique = false, nullable = false)
	private LocalDate datumDolaska;
	
	@Column(name = "datumOdlaska", unique = false, nullable = false)
	private LocalDate datumOdlaska;
	
	@Column(name = "ukupnaCena", unique = false, nullable = false)
	private double ukupnaCena;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Rezervacija rezervacija;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "rezervacijeCenovnika",
    joinColumns = @JoinColumn(name="rezervacija_sobe_id", referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name="cenovnik_usluga_hotela_id", referencedColumnName="id"))
	private Set<CenovnikUslugaHotela> cenovnici = new HashSet<>();
	
	
	public RezervacijaSobe() {
		super();
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


	public Set<CenovnikUslugaHotela> getCenovnici() {
		return cenovnici;
	}



	public void setCenovnici(Set<CenovnikUslugaHotela> cenovnici) {
		this.cenovnici = cenovnici;
	}



	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
	
	
	
}

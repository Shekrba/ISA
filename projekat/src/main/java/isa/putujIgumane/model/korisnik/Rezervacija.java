package isa.putujIgumane.model.korisnik;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import isa.putujIgumane.model.avioKompanija.Karta;
import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.model.rentACar.RezervacijaVozila;

@Entity
public class Rezervacija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(mappedBy="rezervacije",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Korisnik> korisnici=new HashSet<Korisnik>();
	
	@OneToMany(mappedBy="rezervacija",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RezervacijaSobe> rezervacijaSobe = new HashSet<RezervacijaSobe>();
	
	@OneToMany(mappedBy="rezervacija",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RezervacijaVozila> rezervacijaVozila = new HashSet<RezervacijaVozila>();
	
	@OneToMany(mappedBy="rezervacija",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Karta> avionskaKarta = new HashSet<Karta>();
	
	public Rezervacija() {
		
	}
	
	public Rezervacija(Long id, Set<Karta> avionskaKarta, Set<RezervacijaSobe> rezervacijaSobe,
			Set<RezervacijaVozila> rezervacijaVozila) {
		super();
		this.id = id;
		this.avionskaKarta = avionskaKarta;
		this.rezervacijaSobe = rezervacijaSobe;
		this.rezervacijaVozila = rezervacijaVozila;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Karta> getAvionskaKarta() {
		return avionskaKarta;
	}
	public void setAvionskaKarta(Set<Karta> avionskaKarta) {
		this.avionskaKarta = avionskaKarta;
	}
	public Set<RezervacijaSobe> getRezervacijaSobe() {
		return rezervacijaSobe;
	}
	public void setRezervacijaSobe(Set<RezervacijaSobe> rezervacijaSobe) {
		this.rezervacijaSobe = rezervacijaSobe;
	}
	public Set<RezervacijaVozila> getRezervacijaVozila() {
		return rezervacijaVozila;
	}
	public void setRezervacijaVozila(Set<RezervacijaVozila> rezervacijaVozila) {
		this.rezervacijaVozila = rezervacijaVozila;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	
	
	
	
	
}

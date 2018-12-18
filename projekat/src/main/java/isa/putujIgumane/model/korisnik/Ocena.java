package isa.putujIgumane.model.korisnik;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

public class Ocena {
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(mappedBy = "ocena")
	private Set<Korisnik> korisnik = new HashSet<Korisnik>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<AvioKompanija> avioKompanija = new HashSet<AvioKompanija>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<Hotel> hotel = new HashSet<Hotel>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<RentACar> rentACar = new HashSet<RentACar>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<Let> let = new HashSet<Let>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<Soba> soba = new HashSet<Soba>();
	
	@ManyToMany(mappedBy = "ocena")
	private Set<Vozilo> vozilo = new HashSet<Vozilo>();
	
	@Column(name = "vrednost", unique = false, nullable = false)
	private byte vrednost;

	public Ocena(Long id, Set<Korisnik> korisnik, Set<AvioKompanija> avioKompanija, Set<Hotel> hotel,
			Set<RentACar> rentACar, Set<Let> let, Set<Soba> soba, Set<Vozilo> vozilo, byte vrednost) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.avioKompanija = avioKompanija;
		this.hotel = hotel;
		this.rentACar = rentACar;
		this.let = let;
		this.soba = soba;
		this.vozilo = vozilo;
		this.vrednost = vrednost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Korisnik> getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Set<Korisnik> korisnik) {
		this.korisnik = korisnik;
	}

	public Set<AvioKompanija> getAvioKompanija() {
		return avioKompanija;
	}

	public void setAvioKompanija(Set<AvioKompanija> avioKompanija) {
		this.avioKompanija = avioKompanija;
	}

	public Set<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(Set<Hotel> hotel) {
		this.hotel = hotel;
	}

	public Set<RentACar> getRentACar() {
		return rentACar;
	}

	public void setRentACar(Set<RentACar> rentACar) {
		this.rentACar = rentACar;
	}

	public Set<Let> getLet() {
		return let;
	}

	public void setLet(Set<Let> let) {
		this.let = let;
	}

	public Set<Soba> getSoba() {
		return soba;
	}

	public void setSoba(Set<Soba> soba) {
		this.soba = soba;
	}

	public Set<Vozilo> getVozilo() {
		return vozilo;
	}

	public void setVozilo(Set<Vozilo> vozilo) {
		this.vozilo = vozilo;
	}

	public byte getVrednost() {
		return vrednost;
	}

	public void setVrednost(byte vrednost) {
		this.vrednost = vrednost;
	}
	
	*/
}

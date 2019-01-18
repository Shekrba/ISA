package isa.putujIgumane.model.rentACar;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import isa.putujIgumane.model.korisnik.Ocena;

@Entity
public class Vozilo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private RentACar rentACar;//Filijala filijala
	
	@Column(name = "registracijaVozila", unique = true, nullable = false)
	private String registracijaVozila;
	
	@Column(name = "markaVozila", unique = false, nullable = false)
	private String markaVozila;
	
	@Column(name = "modelVozila", unique = false, nullable = false)
	private String modelVozila;
	
	@Column(name = "godinaProizvodnje", unique = false, nullable = false)
	private int godinaProizvodnje;
	
	@Column(name = "brojSedista", unique = false, nullable = false)
	private int brojSedista;
	
	@Column(name = "prosecnaOcenaVozila", unique = false, nullable = true)
	private Double prosecnaOcenaVozila;
	
	@OneToMany(mappedBy = "vozilo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<StatusVozila> statusVozila = new HashSet<StatusVozila>();
	
	@OneToMany(mappedBy="vozilo",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();

	
	
	public Set<Ocena> getOcene() {
		return ocene;
	}


	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}


	public Vozilo(Long id, RentACar rentACar, String nazivVozila, String markaVozila, String modelVozila,
			int godinaProizvodnje, int brojSedista, Double prosecnaOcenaVozila, Set<StatusVozila> statusVozila) {
		super();
		this.id = id;
		this.rentACar = rentACar;
		this.registracijaVozila = nazivVozila;
		this.markaVozila = markaVozila;
		this.modelVozila = modelVozila;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brojSedista = brojSedista;
		this.prosecnaOcenaVozila = prosecnaOcenaVozila;
		this.statusVozila = statusVozila;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public RentACar getRentACar() {
		return rentACar;
	}


	public void setRentACar(RentACar rentACar) {
		this.rentACar = rentACar;
	}


	public String getMarkaVozila() {
		return markaVozila;
	}


	public void setMarkaVozila(String markaVozila) {
		this.markaVozila = markaVozila;
	}


	public String getModelVozila() {
		return modelVozila;
	}


	public void setModelVozila(String modelVozila) {
		this.modelVozila = modelVozila;
	}


	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}


	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}


	public int getBrojSedista() {
		return brojSedista;
	}


	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}


	public Double getProsecnaOcenaVozila() {
		return prosecnaOcenaVozila;
	}


	public void setProsecnaOcenaVozila(Double prosecnaOcenaVozila) {
		this.prosecnaOcenaVozila = prosecnaOcenaVozila;
	}


	public Set<StatusVozila> getStatusVozila() {
		return statusVozila;
	}


	public void setStatusVozila(Set<StatusVozila> statusVozila) {
		this.statusVozila = statusVozila;
	}


	public String getRegistracijaVozila() {
		return registracijaVozila;
	}


	public void setRegistracijaVozila(String registracijaVozila) {
		this.registracijaVozila = registracijaVozila;
	}
	
	
	
}

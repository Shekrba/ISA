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
import javax.persistence.Version;

import isa.putujIgumane.model.korisnik.Ocena;

@Entity
public class Vozilo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private RentACar rentACar;
	
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
	
	@OneToMany(mappedBy="vozilo",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();
	
	@OneToMany(mappedBy = "vozilo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<StatusVozila> statusVozila = new HashSet<StatusVozila>();
	
	@OneToMany(mappedBy = "vozilo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RezervacijaVozila> rezervacije = new HashSet<RezervacijaVozila>();
	
	@Version
	private long version;
	
	public Vozilo() {
		
	}
	
	public Vozilo(Long id, RentACar rentACar, String nazivVozila, String markaVozila, String modelVozila,
			int godinaProizvodnje, int brojSedista, Set<Ocena> prosecnaOcenaVozila, Set<StatusVozila> statusVozila, Set<RezervacijaVozila> rezervacije) {
		super();
		this.id = id;
		this.rentACar = rentACar;
		this.registracijaVozila = nazivVozila;
		this.markaVozila = markaVozila;
		this.modelVozila = modelVozila;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brojSedista = brojSedista;
		this.ocene = prosecnaOcenaVozila;
		this.statusVozila = statusVozila;
		this.rezervacije = rezervacije;
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


	public Set<Ocena> getProsecnaOcenaVozila() {
		return ocene;
	}


	public void setProsecnaOcenaVozila(Set<Ocena> prosecnaOcenaVozila) {
		this.ocene = prosecnaOcenaVozila;
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

	public Set<RezervacijaVozila> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<RezervacijaVozila> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}

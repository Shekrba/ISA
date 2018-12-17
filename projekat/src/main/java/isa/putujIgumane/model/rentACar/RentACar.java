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
import javax.persistence.OneToMany;

@Entity
public class RentACar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nazivServisa", unique = false, nullable = false)
	private String nazivServisa;
	
	@Column(name = "opisServisa", unique = false, nullable = true)
	private String opisServisa;
	
	@OneToMany(mappedBy = "rentACar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Filijala> filijale = new HashSet<Filijala>();
	
	@Column(name = "prosecnaOcenaServisa", unique = false, nullable = true)
	private Double prosecnaOcenaServisa;
	
	//PREMESTITI U FILIJALU
	@Column(name = "adresaServisa", unique = false, nullable = false)
	private String adresaServisa;
	
	@OneToMany(mappedBy = "rentACar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//"filijala"
	private Set<Vozilo> listaVozila = new HashSet<Vozilo>();
	//
	
	public RentACar(Long id, String nazivServisa, String adresaServisa, String promotivniOpis, Set<Filijala> filijale,
			Set<Vozilo> listaVozila, Double prosecnaOcenaServisa) {
		super();
		this.id = id;
		this.nazivServisa = nazivServisa;
		this.adresaServisa = adresaServisa;
		this.opisServisa = promotivniOpis;
		this.filijale = filijale;
		this.prosecnaOcenaServisa = prosecnaOcenaServisa;
	}

	public String getNazivServisa() {
		return nazivServisa;
	}

	public void setNazivServisa(String nazivServisa) {
		this.nazivServisa = nazivServisa;
	}

	public String getAdresaServisa() {
		return adresaServisa;
	}

	public void setAdresaServisa(String adresaServisa) {
		this.adresaServisa = adresaServisa;
	}

	public Set<Filijala> getFilijale() {
		return filijale;
	}

	public void setFilijale(Set<Filijala> filijale) {
		this.filijale = filijale;
	}

	public Double getProsecnaOcenaServisa() {
		return prosecnaOcenaServisa;
	}

	public void setProsecnaOcenaServisa(Double prosecnaOcenaServisa) {
		this.prosecnaOcenaServisa = prosecnaOcenaServisa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpisServisa() {
		return opisServisa;
	}

	public void setOpisServisa(String opisServisa) {
		this.opisServisa = opisServisa;
	}

	public Set<Vozilo> getListaVozila() {
		return listaVozila;
	}

	public void setListaVozila(Set<Vozilo> listaVozila) {
		this.listaVozila = listaVozila;
	}
	
}

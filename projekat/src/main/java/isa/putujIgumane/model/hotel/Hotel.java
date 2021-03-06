package isa.putujIgumane.model.hotel;

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
import javax.persistence.OneToOne;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Ocena;


@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "naziv", unique = false, nullable = false)
	private String naziv;
	
	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;
	
	@Column(name = "opis", unique = false, nullable = true)
	private String opis; 
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
	private Set<Soba> sobe = new HashSet<Soba>();
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
	private Set<CenovnikUslugaHotela> cenovnikUsluga = new HashSet<CenovnikUslugaHotela>();
	
	@Column(name = "prosecnaOcena", unique = false, nullable = true)
	private Double prosecnaOcena;
	
	@OneToMany(mappedBy="hotel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
	private Korisnik admin;

	
	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Hotel() {
		
	}
	
	public Hotel(Long id, String naziv, String adresa, String opis, Set<Soba> sobe,
			Set<CenovnikUslugaHotela> cenovnikUsluga, Double prosecnaOcena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.opis = opis;
		this.sobe = sobe;
		this.cenovnikUsluga = cenovnikUsluga;
		this.prosecnaOcena = prosecnaOcena;
	}
	
	
	public Korisnik getAdmin() {
		return admin;
	}

	public void setAdmin(Korisnik admin) {
		this.admin = admin;
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Soba> getSobe() {
		return sobe;
	}

	public void setSobe(Set<Soba> sobe) {
		this.sobe = sobe;
	}

	public Set<CenovnikUslugaHotela> getCenovnikUsluga() {
		return cenovnikUsluga;
	}

	public void setCenovnikUsluga(Set<CenovnikUslugaHotela> cenovnikUsluga) {
		this.cenovnikUsluga = cenovnikUsluga;
	}
	
}

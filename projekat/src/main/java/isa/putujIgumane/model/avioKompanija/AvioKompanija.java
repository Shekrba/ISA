package isa.putujIgumane.model.avioKompanija;


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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Ocena;

@Entity
public class AvioKompanija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;

	
	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;
	
	@Column(name = "promotivniOpis", unique = false, nullable = true)
	private String promotivniOpis;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "destinacije",
               joinColumns = @JoinColumn(name="aviokompanija_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="grad_id", referencedColumnName="place_id"))
	private Set<Adresa> destinacijePoslovanja=new HashSet<Adresa>();
	
	@OneToMany(mappedBy="avioKompanija",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Let> letovi=new HashSet<Let>();
	
	@Column(name = "prosecnaOcena", unique = false, nullable = true)
	private Double prosecnaOcena;
	
	@OneToMany(mappedBy="avioKompanija",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
	private Korisnik admin;
	
	public AvioKompanija() {
		
	}
	
	public Set<Ocena> getOcene() {
		return ocene;
	}
	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Adresa> getDestinacijePoslovanja() {
		return destinacijePoslovanja;
	}
	public void setDestinacijePoslovanja(Set<Adresa> destinacijePoslovanja) {
		this.destinacijePoslovanja = destinacijePoslovanja;
	}
	public Set<Let> getLetovi() {
		return letovi;
	}
	public void setLetovi(Set<Let> letovi) {
		this.letovi = letovi;
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
	public String getPromotivniOpis() {
		return promotivniOpis;
	}
	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}
	
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
	public Korisnik getAdmin() {
		return admin;
	}

	public void setAdmin(Korisnik admin) {
		this.admin = admin;
	}
	
}

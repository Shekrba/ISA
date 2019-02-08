package isa.putujIgumane.model.avioKompanija;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
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
import javax.persistence.OneToMany;

import isa.putujIgumane.model.korisnik.Ocena;

@Entity
public class Let {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private AvioKompanija avioKompanija;
	
	@OneToMany(mappedBy="let",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Segment> segmenti=new HashSet<Segment>();
	
	@Column(name = "vremePoletanja", unique = false, nullable = false)
	private LocalDateTime vremePoletanja;
	
	@Column(name = "vremeSletanja", unique = false, nullable = false)
	private LocalDateTime vremeSletanja;
	
	@Column(name = "vremePutovanja", unique = false, nullable = false)
	private Duration vremePutovanja;
	
	@Column(name = "duzinaPutovanja", unique = false, nullable = false)
	private double duzinaPutovanja;
	
	@ManyToMany
    @JoinTable(name = "presedanja",
               joinColumns = @JoinColumn(name="let_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="grad_id", referencedColumnName="place_id"))
	private Set<Adresa> presedanja=new HashSet<Adresa>();
	
	@OneToMany(mappedBy="let",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();

	
	
	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AvioKompanija getAvioKompanija() {
		return avioKompanija;
	}

	public void setAvioKompanija(AvioKompanija avioKompanija) {
		this.avioKompanija = avioKompanija;
	}

	public Set<Segment> getSegmenti() {
		return segmenti;
	}

	public void setSegmenti(Set<Segment> segmenti) {
		this.segmenti = segmenti;
	}


	public LocalDateTime getVremePoletanja() {
		return vremePoletanja;
	}

	public void setVremePoletanja(LocalDateTime vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}

	public LocalDateTime getVremeSletanja() {
		return vremeSletanja;
	}

	public void setVremeSletanja(LocalDateTime vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}

	public Duration getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(Duration vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}

	public double getDuzinaPutovanja() {
		return duzinaPutovanja;
	}

	public void setDuzinaPutovanja(double duzinaPutovanja) {
		this.duzinaPutovanja = duzinaPutovanja;
	}

	public Set<Adresa> getPresedanja() {
		return presedanja;
	}

	public void setPresedanja(Set<Adresa> presedanja) {
		this.presedanja = presedanja;
	}
	
	

	
}

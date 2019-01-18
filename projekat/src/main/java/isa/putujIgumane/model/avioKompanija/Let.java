package isa.putujIgumane.model.avioKompanija;

import java.sql.Time;
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private AvioKompanija avioKompanija;
	
	@OneToMany(mappedBy="let",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Segment> segmenti=new HashSet<Segment>();
	
	@Column(name = "vremePoletanja", unique = false, nullable = false)
	private Date vremePoletanja;
	
	@Column(name = "vremeSletanja", unique = false, nullable = false)
	private Date vremeSletanja;
	
	@Column(name = "vremePutovanja", unique = false, nullable = false)
	private Time vremePutovanja;
	
	@Column(name = "duzinaPutovanja", unique = false, nullable = false)
	private int duzinaPutovanja;
	
	@ManyToMany
    @JoinTable(name = "presedanja",
               joinColumns = @JoinColumn(name="let_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="grad_id", referencedColumnName="id"))
	private Set<Grad> presedanja=new HashSet<Grad>();
	
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

	public Date getVremePoletanja() {
		return vremePoletanja;
	}

	public void setVremePoletanja(Date vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}

	public Date getVremeSletanja() {
		return vremeSletanja;
	}

	public void setVremeSletanja(Date vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}

	public Time getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(Time vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}

	public int getDuzinaPutovanja() {
		return duzinaPutovanja;
	}

	public void setDuzinaPutovanja(int duzinaPutovanja) {
		this.duzinaPutovanja = duzinaPutovanja;
	}

	public Set<Grad> getPresedanja() {
		return presedanja;
	}

	public void setPresedanja(Set<Grad> presedanja) {
		this.presedanja = presedanja;
	}
	
	

	
}

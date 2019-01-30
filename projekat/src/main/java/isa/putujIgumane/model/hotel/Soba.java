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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import isa.putujIgumane.model.korisnik.Ocena;

@Entity
public class Soba {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "brojSobe", unique = false, nullable = false)
	private int brojSobe;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Hotel hotel;
	
	@Column(name = "sprat", unique = false, nullable = false)
	private int sprat;
	
	@Column(name = "brojKreveta", unique = false, nullable = false)
	private int brojKreveta;
	
	@OneToMany(mappedBy = "soba", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<StatusSobe> statusSobe = new HashSet<StatusSobe>();
	
	@OneToMany(mappedBy = "soba", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RezervacijaSobe> rezervacije = new HashSet<RezervacijaSobe>();
	
	@OneToMany(mappedBy="soba",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ocena> ocene=new HashSet<Ocena>();

	
	public Set<Ocena> getOcene() {
		return ocene;
	}



	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}



	public Soba(Long id, int brojSobe, Hotel hotel, int sprat, int brojKreveta, Set<StatusSobe> statusSobe,
			Set<RezervacijaSobe> rezervacije) {
		super();
		this.id = id;
		this.brojSobe = brojSobe;
		this.hotel = hotel;
		this.sprat = sprat;
		this.brojKreveta = brojKreveta;
		this.statusSobe = statusSobe;
		this.rezervacije = rezervacije;
	}
	
	
	
	public Soba() {
		super();
	}



	public Set<RezervacijaSobe> getRezervacije() {
		return rezervacije;
	}



	public void setRezervacije(Set<RezervacijaSobe> rezervacije) {
		this.rezervacije = rezervacije;
	}



	public int getBrojSobe() {
		return brojSobe;
	}
	public void setBrojSobe(int brojSobe) {
		this.brojSobe = brojSobe;
	}
	
	public int getSprat() {
		return sprat;
	}
	public void setSprat(int sprat) {
		this.sprat = sprat;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Set<StatusSobe> getStatusSobe() {
		return statusSobe;
	}
	public void setStatusSobe(Set<StatusSobe> statusSobe) {
		this.statusSobe = statusSobe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

	
}

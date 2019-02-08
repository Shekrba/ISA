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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


@Entity
public class CenovnikUslugaHotela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Hotel hotel;
	
	@Column(name = "usluga", unique = true, nullable = false)
	private String usluga;
	
	@Column(name = "cena", unique = false, nullable = false)
	private Double cena;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<RezervacijaSobe> rezervacijeSobe = new HashSet<>();
	
	@Version
	private long version;
	
	public CenovnikUslugaHotela(Long id, Hotel hotel, String usluga, Double cena) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.usluga = usluga;
		this.cena = cena;
	}

	
	
	public CenovnikUslugaHotela() {
		super();
	}



	


	
	public Set<RezervacijaSobe> getRezervacijeSobe() {
		return rezervacijeSobe;
	}



	public void setRezervacijeSobe(Set<RezervacijaSobe> rezervacijeSobe) {
		this.rezervacijeSobe = rezervacijeSobe;
	}



	public long getVersion() {
		return version;
	}



	public void setVersion(long version) {
		this.version = version;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getUsluga() {
		return usluga;
	}
	public void setUsluga(String usluga) {
		this.usluga = usluga;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
}

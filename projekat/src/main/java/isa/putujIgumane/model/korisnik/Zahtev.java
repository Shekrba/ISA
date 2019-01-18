package isa.putujIgumane.model.korisnik;

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

enum StatusZahteva {
	ODBIJEN, PRIHVACEN, POSLAT
}

@Entity
public class Zahtev {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Korisnik salje;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Korisnik prima;
	
	@Column(name = "status",nullable=false)
	private StatusZahteva status;
	
	public Zahtev() {
		
	}
	
	public Zahtev(Long id, Korisnik salje, Korisnik prima, StatusZahteva status) {
		super();
		this.id = id;
		this.salje = salje;
		this.prima = prima;
		this.status = status;
	}
	public StatusZahteva getStatus() {
		return status;
	}
	public void setStatus(StatusZahteva status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Korisnik getSalje() {
		return salje;
	}
	public void setSalje(Korisnik salje) {
		this.salje = salje;
	}
	public Korisnik getPrima() {
		return prima;
	}
	public void setPrima(Korisnik prima) {
		this.prima = prima;
	}

	
}

package isa.putujIgumane.model.rentACar;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class StatusVozila {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Vozilo vozilo;
	
	@Column(name = "cena", unique = false, nullable = false)
	private double cena;
	
	@Column(name = "voziloJeIznajmljeno", unique = false, nullable = false)
	private boolean voziloJeIznajmljeno;
	
	@Column(name = "datum", unique = false, nullable = false)
	private LocalDate datum;
	
	@Column(name = "popust", unique = false, nullable = false)
	private short popust;
	
	@Version
	private long version;
	
	public StatusVozila() {
		
	}
	
	public StatusVozila(Long id, Vozilo vozilo, double cena, boolean voziloJeIznajmljeno, LocalDate datum, short popust) {
		super();
		this.id = id;
		this.vozilo = vozilo;
		this.cena = cena;
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
		this.datum = datum;
		this.popust = popust;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Vozilo getVozilo() {
		return vozilo;
	}


	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}


	public double getCena() {
		return cena;
	}


	public void setCena(double cena) {
		this.cena = cena;
	}


	public boolean isVoziloJeIznajmljeno() {
		return voziloJeIznajmljeno;
	}


	public void setVoziloJeIznajmljeno(boolean voziloJeIznajmljeno) {
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
	}


	public LocalDate getDatum() {
		return datum;
	}


	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}


	public short getPopust() {
		return popust;
	}


	public void setPopust(short popust) {
		this.popust = popust;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}

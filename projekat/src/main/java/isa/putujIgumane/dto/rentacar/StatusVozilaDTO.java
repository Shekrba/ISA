package isa.putujIgumane.dto.rentacar;

import java.sql.Date;
import java.time.LocalDate;

import isa.putujIgumane.model.rentACar.StatusVozila;

public class StatusVozilaDTO {

	private Long id;
	private VoziloDTO vozilo;
	private double cena;
	private boolean voziloJeIznajmljeno;
	private LocalDate datum;
	private short popust;
	
	
	public StatusVozilaDTO() {

	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VoziloDTO getVozilo() {
		return vozilo;
	}
	public void setVozilo(VoziloDTO vozilo) {
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
	public short getPopust() {
		return popust;
	}
	public void setPopust(short popust) {
		this.popust = popust;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

}

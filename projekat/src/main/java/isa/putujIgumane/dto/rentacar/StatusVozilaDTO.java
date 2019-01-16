package isa.putujIgumane.dto.rentacar;

import java.sql.Date;

import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;

public class StatusVozilaDTO {

	private Long id;
	private Vozilo vozilo;
	private double cena;
	private boolean voziloJeIznajmljeno;
	private Date datum;
	private short popust;
	
	
	public StatusVozilaDTO(StatusVozila s) {
		super();
		this.id = s.getId();
		this.vozilo = s.getVozilo();
		this.cena = s.getCena();
		this.voziloJeIznajmljeno = s.isVoziloJeIznajmljeno();
		this.datum = s.getDatum();
		this.popust = s.getPopust();
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
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public short getPopust() {
		return popust;
	}
	public void setPopust(short popust) {
		this.popust = popust;
	}

}

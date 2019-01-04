package isa.putujIgumane.dto.hotel;

import java.sql.Date;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

public class StatusSobeDTO {
	
	private Long id;
	
	private Soba soba;
	
	private Date datum;
	
	private boolean zauzeto;
	
	private double cena;
	
	private short popust;

	public StatusSobeDTO(StatusSobe ss) {
		super();
		this.id = ss.getId();
		this.soba = ss.getSoba();
		this.datum = ss.getDatum();
		this.zauzeto = ss.isZauzeto();
		this.cena = ss.getCena();
		this.popust = ss.getPopust();
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public boolean isZauzeto() {
		return zauzeto;
	}

	public void setZauzeto(boolean zauzeto) {
		this.zauzeto = zauzeto;
	}

	public short getPopust() {
		return popust;
	}

	public void setPopust(short popust) {
		this.popust = popust;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

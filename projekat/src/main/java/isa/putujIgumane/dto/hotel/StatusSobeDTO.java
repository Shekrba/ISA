package isa.putujIgumane.dto.hotel;

import java.sql.Date;
import java.time.LocalDate;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

public class StatusSobeDTO {
	
	private Long id;
	
	private LocalDate datum;
	
	private boolean zauzeto;
	
	private double cena;
	
	private short popust;

	public StatusSobeDTO() {
		
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
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

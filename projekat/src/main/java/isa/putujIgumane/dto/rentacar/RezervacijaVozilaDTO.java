package isa.putujIgumane.dto.rentacar;

import java.time.LocalDate;


public class RezervacijaVozilaDTO {
	
	private Long id;
	private VoziloDTO vozilo;
	private LocalDate datumDolaska;
	private LocalDate datumOdlaska;
	
	
	public RezervacijaVozilaDTO() {
		
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


	public LocalDate getDatumDolaska() {
		return datumDolaska;
	}


	public void setDatumDolaska(LocalDate datumDolaska) {
		this.datumDolaska = datumDolaska;
	}


	public LocalDate getDatumOdlaska() {
		return datumOdlaska;
	}


	public void setDatumOdlaska(LocalDate datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}
	
	
}

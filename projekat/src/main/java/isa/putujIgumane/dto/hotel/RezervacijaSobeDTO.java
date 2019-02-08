package isa.putujIgumane.dto.hotel;

import java.time.LocalDate;


public class RezervacijaSobeDTO {
	
	private Long id;
	
	private SobaDTO soba;
	
	private LocalDate datumDolaska;
	
	private LocalDate datumOdlaska;
	
	public RezervacijaSobeDTO() {
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public SobaDTO getSoba() {
		return soba;
	}


	public void setSoba(SobaDTO soba) {
		this.soba = soba;
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

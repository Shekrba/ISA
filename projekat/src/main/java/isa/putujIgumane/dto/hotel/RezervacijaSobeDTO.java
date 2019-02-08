package isa.putujIgumane.dto.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;


public class RezervacijaSobeDTO {
	
	private Long id;
	
	private SobaDTO soba;
	
	private Set<CenovnikUslugaHotelaDTO> cenovnici = new HashSet<>();
	
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


	
	
	public Set<CenovnikUslugaHotelaDTO> getCenovnici() {
		return cenovnici;
	}


	public void setCenovnici(Set<CenovnikUslugaHotelaDTO> cenovnici) {
		this.cenovnici = cenovnici;
	}


	public LocalDate getDatumOdlaska() {
		return datumOdlaska;
	}


	public void setDatumOdlaska(LocalDate datumOdlaska) {
		this.datumOdlaska = datumOdlaska;
	}


	
	
}

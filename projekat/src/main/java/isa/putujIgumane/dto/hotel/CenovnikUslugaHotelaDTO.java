package isa.putujIgumane.dto.hotel;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;

public class CenovnikUslugaHotelaDTO {
	private Long id;
	
	private String usluga;
	
	private Double cena;
	
	private boolean dodata = false;
	
	private Long version;
	
	public CenovnikUslugaHotelaDTO() {
		
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Long getVersion() {
		return version;
	}



	public void setVersion(Long version) {
		this.version = version;
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



	public boolean isDodata() {
		return dodata;
	}



	public void setDodata(boolean dodata) {
		this.dodata = dodata;
	}
	
}

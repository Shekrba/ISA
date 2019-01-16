package isa.putujIgumane.dto.hotel;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;

public class CenovnikUslugaHotelaDTO {
private Long id;
	
	private Hotel hotel;
	
	private String usluga;
	
	private Double cena;
	
	
	
	public CenovnikUslugaHotelaDTO(CenovnikUslugaHotela cuh) {
		super();
		this.id = cuh.getId();
		this.hotel = cuh.getHotel();
		this.usluga = cuh.getUsluga();
		this.cena = cuh.getCena();
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
}

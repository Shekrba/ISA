package isa.putujIgumane.dto.hotel;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;

public class CenovnikUslugaHotelaDTO {
	private Long id;
	
	private HotelDTO hotel;
	
	private String usluga;
	
	private Double cena;
	
	
	
	public CenovnikUslugaHotelaDTO(CenovnikUslugaHotela cuh) {
		id = cuh.getId();
		//hotel = new HotelDTO(cuh.getHotel());
		usluga = cuh.getUsluga();
		cena = cuh.getCena();
	}

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
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

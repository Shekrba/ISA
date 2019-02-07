package isa.putujIgumane.dto.rentacar;

import isa.putujIgumane.dto.hotel.HotelDTO;

public class RAdminDTO {
	private Long id;
	private String username;
	private String ime;
	private String prezime;
	private String email;
	private RentACarDTO rentacar;
	
	private RAdminDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RentACarDTO getRentacar() {
		return rentacar;
	}
	public void setRentacar(RentACarDTO rentacar) {
		this.rentacar = rentacar;
	}
	
	
}

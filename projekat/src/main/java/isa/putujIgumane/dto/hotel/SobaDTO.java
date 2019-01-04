package isa.putujIgumane.dto.hotel;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

public class SobaDTO {
	
	private Long id;
	
	private int brojSobe;
	
	private Hotel hotel;
	
	private int sprat;
	
	private int brojKreveta;
	
	private Set<StatusSobe> statusSobe = new HashSet<StatusSobe>();
	
	private Set<RezervacijaSobe> rezervacije = new HashSet<RezervacijaSobe>();
	
	
	public SobaDTO(Soba s) {
		super();
		this.id = s.getId();
		this.brojSobe = s.getBrojSobe();
		this.hotel = s.getHotel();
		this.sprat = s.getSprat();
		this.brojKreveta = s.getBrojKreveta();
		this.statusSobe = s.getStatusSobe();
		this.rezervacije = s.getRezervacije();
	}
	
	
	
	public Set<RezervacijaSobe> getRezervacije() {
		return rezervacije;
	}



	public void setRezervacije(Set<RezervacijaSobe> rezervacije) {
		this.rezervacije = rezervacije;
	}



	public int getBrojSobe() {
		return brojSobe;
	}
	public void setBrojSobe(int brojSobe) {
		this.brojSobe = brojSobe;
	}
	
	public int getSprat() {
		return sprat;
	}
	public void setSprat(int sprat) {
		this.sprat = sprat;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Set<StatusSobe> getStatusSobe() {
		return statusSobe;
	}
	public void setStatusSobe(Set<StatusSobe> statusSobe) {
		this.statusSobe = statusSobe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

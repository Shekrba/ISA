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
	
	//private HotelDTO hotel;
	
	private int sprat;
	
	private int brojKreveta;
	
	/*private Set<StatusSobeDTO> statusSobe = new HashSet<StatusSobeDTO>();
	
	private Set<RezervacijaSobeDTO> rezervacije = new HashSet<RezervacijaSobeDTO>();
	*/
	
	public SobaDTO() {
		
	}
	
	
	
	/*public Set<RezervacijaSobeDTO> getRezervacije() {
		return rezervacije;
	}



	public void setRezervacije(Set<RezervacijaSobeDTO> rezervacije) {
		this.rezervacije = rezervacije;
	}*/



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
	
	
	/*public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}*/
	/*public Set<StatusSobeDTO> getStatusSobe() {
		return statusSobe;
	}
	public void setStatusSobe(Set<StatusSobeDTO> statusSobe) {
		this.statusSobe = statusSobe;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

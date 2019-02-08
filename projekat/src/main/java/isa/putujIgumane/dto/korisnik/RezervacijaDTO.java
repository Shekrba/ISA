package isa.putujIgumane.dto.korisnik;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.dto.aviokompanija.KartaDTO;
import isa.putujIgumane.dto.hotel.RezervacijaSobeDTO;
import isa.putujIgumane.dto.rentacar.RezervacijaVozilaDTO;


public class RezervacijaDTO {
	
	private Long id;
	
	private Set<RezervacijaSobeDTO> rezervacijaSobe = new HashSet<>();
	
	public RezervacijaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<RezervacijaSobeDTO> getRezervacijaSobe() {
		return rezervacijaSobe;
	}

	public void setRezervacijaSobe(Set<RezervacijaSobeDTO> rezervacijaSobe) {
		this.rezervacijaSobe = rezervacijaSobe;
	}
	
}

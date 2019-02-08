package isa.putujIgumane.dto.korisnik;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.dto.aviokompanija.KartaDTO;
import isa.putujIgumane.dto.hotel.RezervacijaSobeDTO;
import isa.putujIgumane.dto.rentacar.RezervacijaVozilaDTO;


public class RezervacijaDTO {
	
	private Long id;
	private Set<KartaDTO> karte = new HashSet<>();
	private Set<RezervacijaSobeDTO> rezervacijaSobe = new HashSet<>();
	private Set<RezervacijaVozilaDTO> rezervacijaVozila = new HashSet<>();
	private Set<KorisnikDTO> korisnici = new HashSet<>();
	
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

	public Set<KartaDTO> getKarte() {
		return karte;
	}

	public void setKarte(Set<KartaDTO> karte) {
		this.karte = karte;
	}

	public void setRezervacijaSobe(Set<RezervacijaSobeDTO> rezervacijaSobe) {
		this.rezervacijaSobe = rezervacijaSobe;
	}

	public Set<RezervacijaVozilaDTO> getRezervacijaVozila() {
		return rezervacijaVozila;
	}

	public void setRezervacijaVozila(Set<RezervacijaVozilaDTO> rezervacijaVozila) {
		this.rezervacijaVozila = rezervacijaVozila;
	}

	public Set<KorisnikDTO> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<KorisnikDTO> korisnici) {
		this.korisnici = korisnici;
	}
	
}

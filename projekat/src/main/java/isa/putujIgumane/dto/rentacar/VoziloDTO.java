package isa.putujIgumane.dto.rentacar;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.dto.hotel.StatusSobeDTO;
import isa.putujIgumane.model.rentACar.Vozilo;

public class VoziloDTO {

	private Long id;
	//private RentACarDTO rentACar;
	private String registracijaVozila;
	private String markaVozila;
	private String modelVozila;
	private int godinaProizvodnje;
	private int brojSedista;
	
	private Long version;
	
	private Set<StatusVozilaDTO> statusVozila;
	//private Double prosecnaOcenaVozila;
	/*private Set<StatusVozilaDTO> statusVozila = new HashSet<StatusVozilaDTO>();
	private Set<RezervacijaVozilaDTO> rezervacije = new HashSet<RezervacijaVozilaDTO>();
	*/
	
	public VoziloDTO() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

/*
	public RentACarDTO getRentACar() {
		return rentACar;
	}


	public void setRentACar(RentACarDTO rentACar) {
		this.rentACar = rentACar;
	}

*/
	public String getRegistracijaVozila() {
		return registracijaVozila;
	}


	public void setRegistracijaVozila(String registracijaVozila) {
		this.registracijaVozila = registracijaVozila;
	}


	public String getMarkaVozila() {
		return markaVozila;
	}


	public void setMarkaVozila(String markaVozila) {
		this.markaVozila = markaVozila;
	}


	public String getModelVozila() {
		return modelVozila;
	}


	public void setModelVozila(String modelVozila) {
		this.modelVozila = modelVozila;
	}


	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}


	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}


	public int getBrojSedista() {
		return brojSedista;
	}


	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}


	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}


	public Set<StatusVozilaDTO> getStatusVozila() {
		return statusVozila;
	}


	public void setStatusVozila(Set<StatusVozilaDTO> statusVozila) {
		this.statusVozila = statusVozila;
	}

/*
	public Double getProsecnaOcenaVozila() {
		return prosecnaOcenaVozila;
	}


	public void setProsecnaOcenaVozila(Double prosecnaOcenaVozila) {
		this.prosecnaOcenaVozila = prosecnaOcenaVozila;
	}

*/

	/*public Set<RezervacijaVozilaDTO> getRezervacije() {
		return rezervacije;
	}


	public void setRezervacije(Set<RezervacijaVozilaDTO> rezervacije) {
		this.rezervacije = rezervacije;
	}*/

}

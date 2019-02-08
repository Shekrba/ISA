package isa.putujIgumane.dto.rentacar;

import java.util.Set;

import isa.putujIgumane.dto.hotel.StatusSobeDTO;

public class VoziloZaRezDTO {

	private Long id;
	
	private String registracijaVozila;
	
	private String markaVozila;
	
	private String modelVozila;
	
	private int brojSedista;
	
	private double cena;
	
	private boolean dodata = false;
	
	private Long version;
	
	private Set<StatusVozilaDTO> statusVozila;
	
	public VoziloZaRezDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public boolean isDodata() {
		return dodata;
	}

	public void setDodata(boolean dodata) {
		this.dodata = dodata;
	}

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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
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
}

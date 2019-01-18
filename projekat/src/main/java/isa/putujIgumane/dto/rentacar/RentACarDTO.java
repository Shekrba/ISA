package isa.putujIgumane.dto.rentacar;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

public class RentACarDTO {
	
	private Long id;
	private String nazivServisa;
	private String opisServisa;
	private Set<FilijalaDTO> filijale = new HashSet<FilijalaDTO>();
	private Double prosecnaOcenaServisa;
	private String adresaServisa;
	private Set<VoziloDTO> listaVozila = new HashSet<VoziloDTO>();
	
	
	public RentACarDTO(RentACar r) {
		id = r.getId();
		nazivServisa = r.getNazivServisa();
		opisServisa = r.getOpisServisa();
		prosecnaOcenaServisa = r.getProsecnaOcenaServisa();
		adresaServisa = r.getAdresaServisa();

		for(Filijala f : r.getFilijale()) {
			filijale.add(new FilijalaDTO(f));
		}
		
		for(Vozilo v : r.getListaVozila()) {
			listaVozila.add(new VoziloDTO(v));
		}
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNazivServisa() {
		return nazivServisa;
	}


	public void setNazivServisa(String nazivServisa) {
		this.nazivServisa = nazivServisa;
	}


	public String getOpisServisa() {
		return opisServisa;
	}


	public void setOpisServisa(String opisServisa) {
		this.opisServisa = opisServisa;
	}


	public Set<FilijalaDTO> getFilijale() {
		return filijale;
	}


	public void setFilijale(Set<FilijalaDTO> filijale) {
		this.filijale = filijale;
	}


	public Double getProsecnaOcenaServisa() {
		return prosecnaOcenaServisa;
	}


	public void setProsecnaOcenaServisa(Double prosecnaOcenaServisa) {
		this.prosecnaOcenaServisa = prosecnaOcenaServisa;
	}


	public String getAdresaServisa() {
		return adresaServisa;
	}


	public void setAdresaServisa(String adresaServisa) {
		this.adresaServisa = adresaServisa;
	}


	public Set<VoziloDTO> getListaVozila() {
		return listaVozila;
	}


	public void setListaVozila(Set<VoziloDTO> listaVozila) {
		this.listaVozila = listaVozila;
	}

}

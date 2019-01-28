package isa.putujIgumane.dto.rentacar;

import java.util.HashSet;
import java.util.Set;


public class RentACarDTO {
	
	private Long id;
	private String nazivServisa;
	private String opisServisa;
	private Set<FilijalaDTO> filijale;
	private Double prosecnaOcenaServisa;
	private String adresaServisa;
	
	
	public RentACarDTO() {

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



}

package isa.putujIgumane.dto.aviokompanija;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class KartaDTO {
	
	private Integer id;
	
	private Boolean kupljena;
	
	private Double popust;
	
	private Double cena;
	
	private long version;
	
	private LocalDateTime vremePoletanja;
	
	private LocalDateTime vremeSletanja;
	
	public KartaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	



	public LocalDateTime getVremePoletanja() {
		return vremePoletanja;
	}





	public void setVremePoletanja(LocalDateTime vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}





	public LocalDateTime getVremeSletanja() {
		return vremeSletanja;
	}





	public void setVremeSletanja(LocalDateTime vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}





	public Double getCena() {
		return cena;
	}



	public long getVersion() {
		return version;
	}



	public void setVersion(long version) {
		this.version = version;
	}



	public void setCena(Double cena) {
		this.cena = cena;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getKupljena() {
		return kupljena;
	}

	public void setKupljena(Boolean kupljena) {
		this.kupljena = kupljena;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}
	
	
}

package isa.putujIgumane.dto.aviokompanija;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import isa.putujIgumane.model.avioKompanija.Sediste;

public class KartaDTO {
	
	private Integer id;
	
	private Boolean kupljena;
	
	private Double popust;
	
	public KartaDTO() {
		// TODO Auto-generated constructor stub
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

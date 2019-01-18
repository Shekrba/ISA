package isa.putujIgumane.dto.aviokompanija;

import java.util.List;
import java.util.Set;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Grad;

public class AvioKompanijaDTO {

	private Integer id;
	private String naziv;
	private String adresa;
	private String promotivniOpis;
	private Set<GradDTO> destinacijePoslovanja;
	
	
	public AvioKompanijaDTO() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getPromotivniOpis() {
		return promotivniOpis;
	}


	public void setPromotivniOpis(String promotivniOpis) {
		this.promotivniOpis = promotivniOpis;
	}


	public Set<GradDTO> getDestinacijePoslovanja() {
		return destinacijePoslovanja;
	}


	public void setDestinacijePoslovanja(Set<GradDTO> destinacijePoslovanja) {
		this.destinacijePoslovanja = destinacijePoslovanja;
	}
	
	
	
	
}

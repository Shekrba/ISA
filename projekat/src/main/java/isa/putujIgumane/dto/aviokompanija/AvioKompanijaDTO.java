package isa.putujIgumane.dto.aviokompanija;

import java.util.List;
import java.util.Set;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Adresa;

public class AvioKompanijaDTO {

	private Integer id;
	private String naziv;
	private String adresa;
	private String promotivniOpis;
	private Set<AdresaDTO> destinacijePoslovanja;
	
	
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


	public Set<AdresaDTO> getDestinacijePoslovanja() {
		return destinacijePoslovanja;
	}


	public void setDestinacijePoslovanja(Set<AdresaDTO> destinacijePoslovanja) {
		this.destinacijePoslovanja = destinacijePoslovanja;
	}
	
	
	
	
}

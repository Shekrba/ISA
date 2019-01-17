package isa.putujIgumane.dto.hotel;

import java.util.HashSet;
import java.util.Set;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;

public class HotelDTO {
	
	private Long id;
	private String naziv;
	private String adresa;
	private String opis; 
	private Set<SobaDTO> sobe = new HashSet<SobaDTO>();
	private Set<CenovnikUslugaHotelaDTO> cenovnikUsluga = new HashSet<CenovnikUslugaHotelaDTO>();
	private Double prosecnaOcena;
	
	public HotelDTO(Hotel h) {
		id = h.getId();
		naziv = h.getNaziv();
		adresa = h.getAdresa();
		opis = h.getOpis();
		//sobe = h.getSobe();
		//cenovnikUsluga = h.getCenovnikUsluga();
		prosecnaOcena = h.getProsecnaOcena();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Set<SobaDTO> getSobe() {
		return sobe;
	}
	public void setSobe(Set<SobaDTO> sobe) {
		this.sobe = sobe;
	}
	public Set<CenovnikUslugaHotelaDTO> getCenovnikUsluga() {
		return cenovnikUsluga;
	}
	public void setCenovnikUsluga(Set<CenovnikUslugaHotelaDTO> cenovnikUsluga) {
		this.cenovnikUsluga = cenovnikUsluga;
	}
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
}

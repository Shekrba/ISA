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
	public AvioKompanijaDTO(AvioKompanija ak) {
		super();
		this.id = ak.getId();
		this.naziv = ak.getNaziv();
		this.adresa = ak.getAdresa();
		this.promotivniOpis = ak.getPromotivniOpis();
		for(Grad g : ak.getDestinacijePoslovanja()) {
			GradDTO gdto=new GradDTO(g);
			destinacijePoslovanja.add(gdto);
		}
	}
	
	
	
	
}

package isa.putujIgumane.dto.aviokompanija;

import isa.putujIgumane.model.avioKompanija.Grad;

public class GradDTO {

	private Long id;
	private String naziv;
	
	public GradDTO(Grad g) {
		this.id=g.getId();
		this.naziv=g.getNaziv();
	}
	
}

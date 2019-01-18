package isa.putujIgumane.dto.rentacar;

import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.dto.rentacar.RentACarDTO;

public class FilijalaDTO {

	private long id;
	private RentACarDTO rentACar;
	private String drzava;
	private String grad;
	
	
	public FilijalaDTO(Filijala f) {
		super();
		this.id = f.getId();
		this.drzava = f.getDrzava();
		this.grad = f.getGrad();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public RentACarDTO getRentACar() {
		return rentACar;
	}


	public void setRentACar(RentACarDTO rentACar) {
		this.rentACar = rentACar;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}

}

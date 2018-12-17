package isa.putujIgumane.model.rentACar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Filijala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private RentACar rentACar;
	
	@Column(name = "drzava", unique = false, nullable = false)
	private String drzava;
	
	@Column(name = "grad", unique = false, nullable = false)
	private String grad;
	
	
	public Filijala(long id, RentACar rentACar, String drzava, String grad) {
		super();
		this.id = id;
		this.rentACar = rentACar;
		this.drzava = drzava;
		this.grad = grad;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public RentACar getRentACar() {
		return rentACar;
	}


	public void setRentACar(RentACar rentACar) {
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

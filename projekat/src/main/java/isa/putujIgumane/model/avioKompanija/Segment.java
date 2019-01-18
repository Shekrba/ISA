package isa.putujIgumane.model.avioKompanija;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Segment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "rbr", unique = false, nullable = false)
	private Short rbr;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Let let;
	
	@OneToMany(mappedBy="segment",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Sediste> sedista=new HashSet<Sediste>();
	
	
	@Column(name = "cena", unique = false, nullable = false)
	private Double cena;

	public Segment() {
		
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Short getRbr() {
		return rbr;
	}


	public void setRbr(Short rbr) {
		this.rbr = rbr;
	}


	public Let getLet() {
		return let;
	}


	public void setLet(Let let) {
		this.let = let;
	}


	public Set<Sediste> getSedista() {
		return sedista;
	}


	public void setSedista(Set<Sediste> sedista) {
		this.sedista = sedista;
	}


	public Double getCena() {
		return cena;
	}


	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	
	
}

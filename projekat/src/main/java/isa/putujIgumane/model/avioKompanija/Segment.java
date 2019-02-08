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
	
	@Column(name = "x", unique = false, nullable = false)
	private Double x;
	
	@Column(name = "y", unique = false, nullable = false)
	private Double y;
	
	@Column(name = "redovi", unique = false, nullable = false)
	private Short redovi;
	
	@Column(name = "kolone", unique = false, nullable = false)
	private Short kolone;
	
	@Column(name = "popust", unique = false, nullable = false)
	private Short popust;
	

	public Short getPopust() {
		return popust;
	}

	public void setPopust(Short popust) {
		this.popust = popust;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	
	public Short getRedovi() {
		return redovi;
	}

	public void setRedovi(Short redovi) {
		this.redovi = redovi;
	}

	public Short getKolone() {
		return kolone;
	}

	public void setKolone(Short kolone) {
		this.kolone = kolone;
	}

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

package isa.putujIgumane.model.avioKompanija;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Grad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "naziv", unique = false, nullable = false)
	private String naziv;
	
	@ManyToMany(mappedBy = "presedanja")
	private Set<Let> presedanje=new HashSet<Let>();
	
	@ManyToMany(mappedBy = "destinacijePoslovanja")
	private Set<AvioKompanija> destinacija=new HashSet<AvioKompanija>();
	
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

	public Set<Let> getPresedanje() {
		return presedanje;
	}

	public void setPresedanje(Set<Let> presedanje) {
		this.presedanje = presedanje;
	}

	public Set<AvioKompanija> getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(Set<AvioKompanija> destinacija) {
		this.destinacija = destinacija;
	}
	
}

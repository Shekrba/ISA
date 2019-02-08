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
public class Adresa {

	@Id
	private String place_id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "presedanja")
	private Set<Let> presedanje=new HashSet<Let>();
	
	@ManyToMany(mappedBy = "destinacijePoslovanja")
	private Set<AvioKompanija> destinacija=new HashSet<AvioKompanija>();
	
	public Adresa() {
		
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPlace_id() {
		return place_id;
	}



	public void setPlace_id(String place_id) {
		this.place_id = place_id;
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

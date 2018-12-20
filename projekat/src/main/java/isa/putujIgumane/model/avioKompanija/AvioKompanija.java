package isa.putujIgumane.model.avioKompanija;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvioKompanija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;
	
	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;
	
	@Column(name = "promotivniOpis", unique = false, nullable = true)
	private String promotivniOpis;
	
	
	private Set<String> destinacije=new HashSet<String>();
	
	private Set<Let> letovi=new HashSet<Let>();
	private Set<Karta> karteSaPopustima = new HashSet<Karta>();
	private ArrayList<Segment> segmenti;
	
	@Column(name = "prosecnaOcena", unique = false, nullable = true)
	private Double prosecnaOcena;
	
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
	
	public ArrayList<Segment> getSegmenti() {
		return segmenti;
	}
	public void setSegmenti(ArrayList<Segment> segmenti) {
		this.segmenti = segmenti;
	}
	public Double getProsecnaOcena() {
		return prosecnaOcena;
	}
	public void setProsecnaOcena(Double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}
	
}

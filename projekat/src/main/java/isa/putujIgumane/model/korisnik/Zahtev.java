package isa.putujIgumane.model.korisnik;

import java.util.HashSet;
import java.util.Set;

public class Zahtev {
	private Long id;
	private Set<Korisnik> salje = new HashSet<Korisnik>();
	private Set<Korisnik> prima = new HashSet<Korisnik>();
	private Boolean potvrdjen;
	public Zahtev(Set<Korisnik> salje, Set<Korisnik> prima, Boolean potvrdjen) {
		super();
		this.salje = salje;
		this.prima = prima;
		this.potvrdjen = potvrdjen;
	}
	public Set<Korisnik> getSalje() {
		return salje;
	}
	public void setSalje(Set<Korisnik> salje) {
		this.salje = salje;
	}
	public Set<Korisnik> getPrima() {
		return prima;
	}
	public void setPrima(Set<Korisnik> prima) {
		this.prima = prima;
	}
	public Boolean getPotvrdjen() {
		return potvrdjen;
	}
	public void setPotvrdjen(Boolean potvrdjen) {
		this.potvrdjen = potvrdjen;
	}
	
	
}

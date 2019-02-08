package isa.putujIgumane.dto.hotel;

import java.util.Set;

public class SobaZaRezDTO {
	
	private Long id;
	
	private int brojSobe;
	
	private int sprat;
	
	private int brojKreveta;
	
	private boolean dodata = false;
	
	private double cena;
	
	private Long version;
	
	private Set<StatusSobeDTO> statusSobe;
	
	public SobaZaRezDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojSobe() {
		return brojSobe;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

	public Set<StatusSobeDTO> getStatusSobe() {
		return statusSobe;
	}

	public void setStatusSobe(Set<StatusSobeDTO> statusSobe) {
		this.statusSobe = statusSobe;
	}

	public void setBrojSobe(int brojSobe) {
		this.brojSobe = brojSobe;
	}

	public int getSprat() {
		return sprat;
	}

	public void setSprat(int sprat) {
		this.sprat = sprat;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public boolean isDodata() {
		return dodata;
	}

	public void setDodata(boolean dodata) {
		this.dodata = dodata;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
}

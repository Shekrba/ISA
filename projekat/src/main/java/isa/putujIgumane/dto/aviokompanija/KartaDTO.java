package isa.putujIgumane.dto.aviokompanija;



public class KartaDTO {
	
	private Integer id;
	
	private Boolean kupljena;
	
	private Double popust;
	
	private Double cena;
	
	private long version;
	
	private SedisteDTO sediste;
	
	public KartaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SedisteDTO getSediste() {
		return sediste;
	}



	public void setSediste(SedisteDTO sediste) {
		this.sediste = sediste;
	}



	public Double getCena() {
		return cena;
	}



	public long getVersion() {
		return version;
	}



	public void setVersion(long version) {
		this.version = version;
	}



	public void setCena(Double cena) {
		this.cena = cena;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getKupljena() {
		return kupljena;
	}

	public void setKupljena(Boolean kupljena) {
		this.kupljena = kupljena;
	}

	public Double getPopust() {
		return popust;
	}

	public void setPopust(Double popust) {
		this.popust = popust;
	}
	
	
}

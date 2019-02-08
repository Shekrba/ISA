package isa.putujIgumane.dto.rentacar;

public class VozilaBrzaDTO {

	private Long id;
	
	private String registracijaVozila;
	
	private String markaVozila;
	
	private String modelVozila;
	
	private int brojSedista;
	
	private double cena;
	
	private short popust;

	public VozilaBrzaDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistracijaVozila() {
		return registracijaVozila;
	}

	public void setRegistracijaVozila(String registracijaVozila) {
		this.registracijaVozila = registracijaVozila;
	}

	public String getMarkaVozila() {
		return markaVozila;
	}

	public void setMarkaVozila(String markaVozila) {
		this.markaVozila = markaVozila;
	}

	public String getModelVozila() {
		return modelVozila;
	}

	public void setModelVozila(String modelVozila) {
		this.modelVozila = modelVozila;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public short getPopust() {
		return popust;
	}

	public void setPopust(short popust) {
		this.popust = popust;
	}
	
}

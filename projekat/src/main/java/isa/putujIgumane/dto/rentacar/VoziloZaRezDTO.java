package isa.putujIgumane.dto.rentacar;

public class VoziloZaRezDTO {

	private Long id;
	
	private String registracijaVozila;
	
	private String markaVozila;
	
	private String modelVozila;
	
	private int brojSedista;
	
	private boolean dodata = false;
	
	public VoziloZaRezDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public boolean isDodata() {
		return dodata;
	}

	public void setDodata(boolean dodata) {
		this.dodata = dodata;
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
}

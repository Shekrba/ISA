package isa.putujIgumane.model.rentACar;

import java.sql.Date;


public class Vozilo {
	private String nazivVozila;
	private String markaVozila;
	private String modelVozila;
	private int godinaProizvodnje;
	private int brojSedista;
	private Double prosecnaOcenaVozila;
	private int cenaIznajmljivanjaVozilaPoDanu;
	private boolean voziloJeIznajmljeno;
	private Date datumKadaJeIznajmljeno;
	private Date datumDoKadaJeIznajmljeno;
	private boolean voziloJeIzbrisano;
	private int popust;
	
	public Vozilo(String nazivVozila, String markaVozila, String modelVozila, int godinaProizvodnje, int brojSedista,
			Double prosecnaOcenaVozila, int cenaIznajmljivanjaVozilaPoDanu, boolean voziloJeIznajmljeno,
			Date datumKadaJeIznajmljeno, Date datumDoKadaJeIznajmljeno, boolean voziloJeIzbrisano, int popust) {
		super();
		this.nazivVozila = nazivVozila;
		this.markaVozila = markaVozila;
		this.modelVozila = modelVozila;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brojSedista = brojSedista;
		this.prosecnaOcenaVozila = prosecnaOcenaVozila;
		this.cenaIznajmljivanjaVozilaPoDanu = cenaIznajmljivanjaVozilaPoDanu;
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
		this.datumKadaJeIznajmljeno = datumKadaJeIznajmljeno;
		this.datumDoKadaJeIznajmljeno = datumDoKadaJeIznajmljeno;
		this.voziloJeIzbrisano = voziloJeIzbrisano;
		this.popust = popust;
	}

	

	public String getNazivVozila() {
		return nazivVozila;
	}

	public void setNazivVozila(String nazivVozila) {
		this.nazivVozila = nazivVozila;
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

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public Double getProsecnaOcenaVozila() {
		return prosecnaOcenaVozila;
	}

	public void setProsecnaOcenaVozila(Double prosecnaOcenaVozila) {
		this.prosecnaOcenaVozila = prosecnaOcenaVozila;
	}

	public int getCenaIznajmljivanjaVozilaPoDanu() {
		return cenaIznajmljivanjaVozilaPoDanu;
	}

	public void setCenaIznajmljivanjaVozilaPoDanu(int cenaIznajmljivanjaVozilaPoDanu) {
		this.cenaIznajmljivanjaVozilaPoDanu = cenaIznajmljivanjaVozilaPoDanu;
	}

	public boolean isVoziloJeIznajmljeno() {
		return voziloJeIznajmljeno;
	}

	public void setVoziloJeIznajmljeno(boolean voziloJeIznajmljeno) {
		this.voziloJeIznajmljeno = voziloJeIznajmljeno;
	}

	public Date getDatumKadaJeIznajmljeno() {
		return datumKadaJeIznajmljeno;
	}

	public void setDatumKadaJeIznajmljeno(Date datumKadaJeIznajmljeno) {
		this.datumKadaJeIznajmljeno = datumKadaJeIznajmljeno;
	}

	public Date getDatumDoKadaJeIznajmljeno() {
		return datumDoKadaJeIznajmljeno;
	}

	public void setDatumDoKadaJeIznajmljeno(Date datumDoKadaJeIznajmljeno) {
		this.datumDoKadaJeIznajmljeno = datumDoKadaJeIznajmljeno;
	}

	public boolean isVoziloJeIzbrisano() {
		return voziloJeIzbrisano;
	}

	public void setVoziloJeIzbrisano(boolean voziloJeIzbrisano) {
		this.voziloJeIzbrisano = voziloJeIzbrisano;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}
	
}

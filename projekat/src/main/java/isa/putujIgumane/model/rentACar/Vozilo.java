package isa.putujIgumane.model.rentACar;

import java.sql.Date;

import isa.putujIgumane.model.ProsecnaOcena;

public class Vozilo {
	private String nazivVozila;
	private String markaVozila;
	private String modelVozila;
	private int godinaProizvodnje;
	private int brojSedista;
	private ProsecnaOcena prosecnaOcenaVozila;
	private int cenaIznajmljivanjaVozilaPoDanu;
	private boolean voziloJeIznajmljeno;
	private Date datumKadaJeIznajmljeno;
	private Date datumDoKadaJeIznajmljeno;
	private boolean voziloJeIzbrisano;
	private int popust;
	
	public Vozilo(String nazivVozila, String markaVozila, String modelVozila, int godinaProizvodnje, int brojSedista,
			ProsecnaOcena prosecnaOcenaVozila, int cenaIznajmljivanjaVozilaPoDanu, boolean voziloJeIznajmljeno,
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

	public Vozilo() {
		super();
		this.nazivVozila = "";
		this.markaVozila = "";
		this.modelVozila = "";
		this.godinaProizvodnje = 1900;
		this.brojSedista = 4;
		this.prosecnaOcenaVozila.setBrojOcena(0);
		this.prosecnaOcenaVozila.setTrenutnaOcena(0);
		this.cenaIznajmljivanjaVozilaPoDanu = 0;
		this.voziloJeIznajmljeno = false;
		this.datumKadaJeIznajmljeno = null;
		this.datumDoKadaJeIznajmljeno = null;
		this.voziloJeIzbrisano = false;
		this.popust = 0;
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

	public ProsecnaOcena getProsecnaOcenaVozila() {
		return prosecnaOcenaVozila;
	}

	public void setProsecnaOcenaVozila(ProsecnaOcena prosecnaOcenaVozila) {
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

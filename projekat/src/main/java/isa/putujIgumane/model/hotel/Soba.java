package isa.putujIgumane.model.hotel;

import java.sql.Date;
import java.util.HashMap;

enum TipSobe {
	JEDNOKREVETNA,DVOKREVETNA,TROKREVETNA,CETVOROKREVETNA
}

public class Soba {
	private int brojSobe;
	private HashMap<Date, Double> cenovnikNocenja;
	private HashMap<String, Integer> cenovnikUsluga;
	private int sprat;
	private int brojKreveta;
	private TipSobe tipSobe;
	private Date datumDolaska;
	private int brojNocenja;
	private int brojGostuju;
	
	private boolean popust;
	private int pocenatPopusta;
	private Date datumPocetkaPopusta;
	private Date datumZavrsetkaPopusta;
	
	public Soba(int brojSobe, int sprat, int brojKreveta, TipSobe tipSobe) {
		super();
		this.brojSobe = brojSobe;
		this.sprat = sprat;
		this.brojKreveta = brojKreveta;
		this.tipSobe = tipSobe;
		this.cenovnikNocenja = new HashMap<>();
		this.cenovnikUsluga = new HashMap<>();
		this.datumDolaska = null;
		this.brojNocenja = 0;
		this.brojGostuju = 0;
		
		this.popust = false;
		this.pocenatPopusta = 0;
		this.datumPocetkaPopusta = null;
		this.datumZavrsetkaPopusta = null;
	}
	
	public int getBrojSobe() {
		return brojSobe;
	}
	public void setBrojSobe(int brojSobe) {
		this.brojSobe = brojSobe;
	}
	public HashMap<Date, Double> getCenovnikNocenja() {
		return cenovnikNocenja;
	}
	public void setCenovnikNocenja(HashMap<Date, Double> cenovnikNocenja) {
		this.cenovnikNocenja = cenovnikNocenja;
	}
	public HashMap<String, Integer> getCenovnikUsluga() {
		return cenovnikUsluga;
	}
	public void setCenovnikUsluga(HashMap<String, Integer> cenovnikUsluga) {
		this.cenovnikUsluga = cenovnikUsluga;
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
	public TipSobe getTipSobe() {
		return tipSobe;
	}
	public void setTipSobe(TipSobe tipSobe) {
		this.tipSobe = tipSobe;
	}
	public Date getDatumDolaska() {
		return datumDolaska;
	}
	public void setDatumDolaska(Date datumDolaska) {
		this.datumDolaska = datumDolaska;
	}
	public int getBrojNocenja() {
		return brojNocenja;
	}
	public void setBrojNocenja(int brojNocenja) {
		this.brojNocenja = brojNocenja;
	}
	public int getBrojGostuju() {
		return brojGostuju;
	}
	public void setBrojGostuju(int brojGostuju) {
		this.brojGostuju = brojGostuju;
	}
	public boolean isPopust() {
		return popust;
	}
	public void setPopust(boolean popust) {
		this.popust = popust;
	}
	public int getPocenatPopusta() {
		return pocenatPopusta;
	}
	public void setPocenatPopusta(int pocenatPopusta) {
		this.pocenatPopusta = pocenatPopusta;
	}
	public Date getDatumPocetkaPopusta() {
		return datumPocetkaPopusta;
	}
	public void setDatumPocetkaPopusta(Date datumPocetkaPopusta) {
		this.datumPocetkaPopusta = datumPocetkaPopusta;
	}
	public Date getDatumZavrsetkaPopusta() {
		return datumZavrsetkaPopusta;
	}
	public void setDatumZavrsetkaPopusta(Date datumZavrsetkaPopusta) {
		this.datumZavrsetkaPopusta = datumZavrsetkaPopusta;
	}
}

package isa.putujIgumane.model;

public class ProsecnaOcena {
	private double trenutnaOcena;
	private int brojOcena;
	
	public ProsecnaOcena() {
		trenutnaOcena = 0;
		brojOcena = 0;
	}
	
	public double getTrenutnaOcena() {
		return trenutnaOcena;
	}
	public void setTrenutnaOcena(double trenutnaOcena) {
		this.trenutnaOcena = trenutnaOcena;
	}
	public int getBrojOcena() {
		return brojOcena;
	}
	public void setBrojOcena(int brojOcena) {
		this.brojOcena = brojOcena;
	}
	
	public void update(int ocena) {
		trenutnaOcena = (trenutnaOcena * brojOcena + ocena)/(brojOcena + 1);
		brojOcena++;
	}
	
}

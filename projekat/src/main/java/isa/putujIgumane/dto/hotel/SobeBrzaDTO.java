package isa.putujIgumane.dto.hotel;

public class SobeBrzaDTO {
	
	private Long id;
	
	private int brojSobe;
	
	private int sprat;
	
	private int brojKreveta;
	
	private double cena;
	
	private short popust;
	
	public SobeBrzaDTO() {
		// TODO Auto-generated constructor stub
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

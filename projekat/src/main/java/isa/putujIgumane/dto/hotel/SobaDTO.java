package isa.putujIgumane.dto.hotel;

public class SobaDTO {
	
	private Long id;
	
	private int brojSobe;
	
	private int sprat;
	
	private int brojKreveta;
	
	public SobaDTO() {
		
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

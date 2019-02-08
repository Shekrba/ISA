package isa.putujIgumane.dto.aviokompanija;



public class SedisteDTO {

	private Integer id;
	
	private Short rbr;
	
	private KartaDTO karta;
	
	public SedisteDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getRbr() {
		return rbr;
	}

	public void setRbr(Short rbr) {
		this.rbr = rbr;
	}

	public KartaDTO getKarta() {
		return karta;
	}

	public void setKarta(KartaDTO karta) {
		this.karta = karta;
	}
	
	
	
}

package isa.putujIgumane.dto.aviokompanija;



public class SedisteDTO {

	private Integer id;
	
	private Short rbr;
	
	private KartaDTO karta;
	
	private SegmentDTO segment;
	
	public SedisteDTO() {
		
	}
	

	public SegmentDTO getSegment() {
		return segment;
	}


	public void setSegment(SegmentDTO segment) {
		this.segment = segment;
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

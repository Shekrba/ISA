package isa.putujIgumane.dto.aviokompanija;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class LetDTO {

	
	private Long id;
	
	private AvioKompanijaDTO avioKompanija;
	
	private Set<SegmentDTO> segmenti=new HashSet<SegmentDTO>();
	
	private LocalDateTime vremePoletanja;
	
	
	private LocalDateTime vremeSletanja;
	
	
	private Duration vremePutovanja;
	
	
	private double duzinaPutovanja;
	
	private Set<AdresaDTO> presedanja;
	
	public LetDTO() {
		
	}

	
	public Set<SegmentDTO> getSegmenti() {
		return segmenti;
	}


	public void setSegmenti(Set<SegmentDTO> segmenti) {
		this.segmenti = segmenti;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AvioKompanijaDTO getAvioKompanija() {
		return avioKompanija;
	}

	public void setAvioKompanija(AvioKompanijaDTO avioKompanija) {
		this.avioKompanija = avioKompanija;
	}


	public LocalDateTime getVremePoletanja() {
		return vremePoletanja;
	}

	public void setVremePoletanja(LocalDateTime vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}

	public LocalDateTime getVremeSletanja() {
		return vremeSletanja;
	}

	public void setVremeSletanja(LocalDateTime vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}

	public Duration getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(Duration vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}

	public double getDuzinaPutovanja() {
		return duzinaPutovanja;
	}

	public void setDuzinaPutovanja(double duzinaPutovanja) {
		this.duzinaPutovanja = duzinaPutovanja;
	}

	public Set<AdresaDTO> getPresedanja() {
		return presedanja;
	}

	public void setPresedanja(Set<AdresaDTO> presedanja) {
		this.presedanja = presedanja;
	}
	
	
	
}

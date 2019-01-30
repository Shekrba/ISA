package isa.putujIgumane.dto.korisnik;

public class ZahtevDTO {

	Long id;
	KorisnikDTO salje;
	
	public ZahtevDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KorisnikDTO getSalje() {
		return salje;
	}

	public void setSalje(KorisnikDTO salje) {
		this.salje = salje;
	}
	
	
}

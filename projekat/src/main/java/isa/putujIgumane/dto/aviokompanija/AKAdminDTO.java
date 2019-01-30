package isa.putujIgumane.dto.aviokompanija;

public class AKAdminDTO {

	private Long id;
	private String username;
	private String ime;
	private String prezime;
	private String email;
	private AvioKompanijaDTO avioKompanija;
	
	public AKAdminDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AvioKompanijaDTO getAvioKompanija() {
		return avioKompanija;
	}

	public void setAvioKompanija(AvioKompanijaDTO avioKompanija) {
		this.avioKompanija = avioKompanija;
	}

	
	
}

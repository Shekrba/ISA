package isa.putujIgumane.dto.korisnik;

public class AdminRentDTO {
	private Long id;
	private String username;
	private String password;
	private String ime;
	private String prezime;
	private String email;
	private String rentNaz;
	
	public AdminRentDTO() {
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRentNaz() {
		return rentNaz;
	}

	public void setRentNaz(String rentNaz) {
		this.rentNaz = rentNaz;
	}
	
	
}

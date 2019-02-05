package isa.putujIgumane.dto.rentacar;

public class OcenaRentacarDTO {

	private String username;
	private byte vrednost;
	
	
	public OcenaRentacarDTO(String username, byte vrednost) {
		super();
		this.username = username;
		this.vrednost = vrednost;
	}
	
	public OcenaRentacarDTO() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte getVrednost() {
		return vrednost;
	}

	public void setVrednost(byte vrednost) {
		this.vrednost = vrednost;
	}
	
}

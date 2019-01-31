package isa.putujIgumane.dto.hotel;

public class OcenaHotelaDTO {
	private String username;
	private byte vrednost;
	
	public OcenaHotelaDTO() {
		
	}
	
	public OcenaHotelaDTO(String u, byte v){
		username = u;
		vrednost = v;
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

package isa.putujIgumane.model.korisnik;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

enum TipKorisnika {
	REGISTROVANI, AVIOADMIN, HOTELADMIN, RENTACARADMIN, ADMIN
}

@Entity
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Column(name = "ime", unique = false, nullable = false)
	private String ime;
	
	@Column(name = "prezime", unique = false, nullable = false)
	private String prezime;
	
	@Column(name = "tip", unique = false, nullable = false)
	private TipKorisnika tip;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "verifikovan")
	private boolean verifikovan;
	
	@ManyToMany
	@JoinTable(name="prijatelji",
	 joinColumns=@JoinColumn(name="firstUserID"),
	 inverseJoinColumns=@JoinColumn(name="secondUserID")
	)
	private Set<Korisnik> prijatelji = new HashSet<Korisnik>();
	
	@ManyToMany
	@JoinTable(name="prijatelji",
	 joinColumns=@JoinColumn(name="secondUserID"),
	 inverseJoinColumns=@JoinColumn(name="firstUserID")
	)
	private Set<Korisnik> prijateljOd = new HashSet<Korisnik>();
	

	@OneToMany(mappedBy="salje",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Zahtev> poslatiZahtevi = new HashSet<Zahtev>();
	
	@OneToMany(mappedBy="prima",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Zahtev> primljeniZahtevi = new HashSet<Zahtev>();
	
	@OneToMany(mappedBy="korisnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene = new HashSet<Ocena>();
	
	@OneToMany(mappedBy="korisnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();

	
	public Korisnik() {
		
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

	public TipKorisnika getTip() {
		return tip;
	}

	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVerifikovan() {
		return verifikovan;
	}

	public void setVerifikovan(boolean verifikovan) {
		this.verifikovan = verifikovan;
	}

	public Set<Korisnik> getPrijatelji() {
		return prijatelji;
	}

	public void setPrijatelji(Set<Korisnik> prijatelji) {
		this.prijatelji = prijatelji;
	}

	public Set<Korisnik> getPrijateljOd() {
		return prijateljOd;
	}

	public void setPrijateljOd(Set<Korisnik> prijateljOd) {
		this.prijateljOd = prijateljOd;
	}

	public Set<Zahtev> getPoslatiZahtevi() {
		return poslatiZahtevi;
	}

	public void setPoslatiZahtevi(Set<Zahtev> poslatiZahtevi) {
		this.poslatiZahtevi = poslatiZahtevi;
	}

	public Set<Zahtev> getPrimljeniZahtevi() {
		return primljeniZahtevi;
	}

	public void setPrimljeniZahtevi(Set<Zahtev> primljeniZahtevi) {
		this.primljeniZahtevi = primljeniZahtevi;
	}

	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Set<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(Set<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
	
	
	
}

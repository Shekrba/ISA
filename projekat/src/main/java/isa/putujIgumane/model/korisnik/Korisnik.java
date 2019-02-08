package isa.putujIgumane.model.korisnik;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.fasterxml.jackson.annotation.JsonIgnore;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.rentACar.RentACar;

import javax.persistence.JoinColumn;



@Entity
public class Korisnik implements UserDetails{
	
	 
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Column(name = "ime", unique = false, nullable = false)
	private String ime;
	
	@Column(name = "prezime", unique = false, nullable = false)
	private String prezime;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "verifikovan")
	private boolean verifikovan;
	

	@OneToMany(mappedBy="salje",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Zahtev> poslatiZahtevi = new HashSet<Zahtev>();
	
	@OneToMany(mappedBy="prima",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Zahtev> primljeniZahtevi = new HashSet<Zahtev>();
	
	@OneToMany(mappedBy="korisnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Ocena> ocene = new HashSet<Ocena>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "korisnik_rezervacije",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "rezervacija_id", referencedColumnName = "id"))
	private Set<Rezervacija> rezervacije = new HashSet<Rezervacija>();
	
	@Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;
	
	@Column(name = "enabled")
    private boolean enabled;
	
	@OneToOne(mappedBy="admin",fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
	private AvioKompanija avioKompanija;
	
	@OneToOne(mappedBy="admin",fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
	private Hotel hotel;
	
	@OneToOne(mappedBy="admin",fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
	private RentACar rentACar;
	
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
		Timestamp now = new Timestamp(new java.util.Date().getTime());
        this.setLastPasswordResetDate( now );
        this.password = password;
	}

	public Timestamp getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
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

	public boolean isVerifikovan() {
		return verifikovan;
	}

	public void setVerifikovan(boolean verifikovan) {
		this.verifikovan = verifikovan;
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

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public AvioKompanija getAvioKompanija() {
		return avioKompanija;
	}

	public void setAvioKompanija(AvioKompanija avioKompanija) {
		this.avioKompanija = avioKompanija;
	}
	
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public RentACar getRentACar() {
		return rentACar;
	}

	public void setRentACar(RentACar rentACar) {
		this.rentACar = rentACar;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	        return this.authorities;
	}

	

	@JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

	
	
	
	
}

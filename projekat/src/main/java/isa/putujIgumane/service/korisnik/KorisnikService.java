package isa.putujIgumane.service.korisnik;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.korisnik.AdminAvioDTO;
import isa.putujIgumane.dto.korisnik.AdminHotelaDTO;
import isa.putujIgumane.dto.korisnik.AdminRentDTO;
import isa.putujIgumane.dto.korisnik.KorisnikDTO;
import isa.putujIgumane.dto.korisnik.RezervacijaDTO;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Rezervacija;
import isa.putujIgumane.model.korisnik.Zahtev;


public interface KorisnikService {

	public Korisnik getKorisnik(Long id);
	
	public Korisnik getKorisnik(String username);
	
	public Page<Korisnik> getKorisnikLike(Pageable pageable,String s,String loggedUser);
	
	public void sendFriendRequest(String username,Long friend) throws Exception;
	
	public List<Long> getFriendsAndRequests(String username);
	
	public void answerRequest(Long id,boolean flag);
	
	public List<Zahtev> getFriendsRequests(String username);
	
	public Korisnik addKorisnik(KorisnikDTO korisnik);
	
	public Korisnik addAdminHotel(AdminHotelaDTO admin);
	
	public Korisnik addAdminAvio(AdminAvioDTO admin);
	
	public Korisnik addAdminRent(AdminRentDTO admin);
	
	public Rezervacija makeRez(RezervacijaDTO rez) throws Exception;
}

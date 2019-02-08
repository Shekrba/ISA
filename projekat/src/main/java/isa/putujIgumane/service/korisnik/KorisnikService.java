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

@Service
public interface KorisnikService {

	public abstract Korisnik getKorisnik(Long id);
	
	public abstract Korisnik getKorisnik(String username);
	
	public abstract Page<Korisnik> getKorisnikLike(Pageable pageable,String s,String loggedUser);
	
	public abstract void sendFriendRequest(String username,Long friend) throws Exception;
	
	public abstract List<Long> getFriendsAndRequests(String username);
	
	public abstract void answerRequest(Long id,boolean flag);
	
	public abstract List<Zahtev> getFriendsRequests(String username);
	
	public abstract Korisnik addKorisnik(KorisnikDTO korisnik);
	
	public abstract Korisnik addAdminHotel(AdminHotelaDTO admin);
	
	public abstract Korisnik addAdminAvio(AdminAvioDTO admin);
	
	public abstract Korisnik addAdminRent(AdminRentDTO admin);
	
	public abstract Rezervacija makeRez(RezervacijaDTO rez,Korisnik k);
}

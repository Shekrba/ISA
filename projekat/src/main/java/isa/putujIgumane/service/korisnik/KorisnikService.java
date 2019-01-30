package isa.putujIgumane.service.korisnik;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.korisnik.Korisnik;
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
}

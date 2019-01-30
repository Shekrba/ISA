package isa.putujIgumane.service.korisnik;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.korisnik.Korisnik;

@Service
public interface KorisnikService {

	public abstract Korisnik getKorisnik(Long id);
	
	public abstract Page<Korisnik> getKorisnikLike(Pageable pageable,String s,String loggedUser);
	
	public abstract void sendFriendRequest(String username,Long friend) throws Exception;
	
}

package isa.putujIgumane.service.korisnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.repository.korisnik.KorisnikRepository;

@Service
public class KorisnikServiceImpl implements KorisnikService{

	@Autowired 
	KorisnikRepository korisnikRepo;
	
	@Override
	public Korisnik getKorisnik(Long id) {
		return korisnikRepo.findById(id);
	}

	@Override
	public Page<Korisnik> getKorisnikLike(Pageable pageable, String s,String loggedUser) {
		return korisnikRepo.searchByFullName(pageable, s, loggedUser);
	}

	

}

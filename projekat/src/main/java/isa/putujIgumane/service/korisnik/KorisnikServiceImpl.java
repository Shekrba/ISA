package isa.putujIgumane.service.korisnik;

import org.springframework.beans.factory.annotation.Autowired;

import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.repository.korisnik.KorisnikRepository;

public class KorisnikServiceImpl implements KorisnikService{

	@Autowired 
	KorisnikRepository korisnikRepo;
	
	@Override
	public Korisnik getKorisnik(Long id) {
		return korisnikRepo.findById(id);
	}

}

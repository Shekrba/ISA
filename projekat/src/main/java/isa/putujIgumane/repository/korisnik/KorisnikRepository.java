package isa.putujIgumane.repository.korisnik;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.korisnik.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	Korisnik findById(Long id);
	
	Korisnik findByUsername(String username);
}

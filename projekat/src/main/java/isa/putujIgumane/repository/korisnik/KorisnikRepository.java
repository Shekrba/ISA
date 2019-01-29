package isa.putujIgumane.repository.korisnik;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.putujIgumane.model.korisnik.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	Korisnik findById(Long id);
	
	Korisnik findByUsername(String username);
	
	@Query("FROM Korisnik k WHERE k.ime LIKE  '%?2%' OR k.prezime LIKE '%?2%' AND k.username!=?3 ")
	Page<Korisnik> searchByFullName(Pageable pageable,String s,String loggedUser);
}

package isa.putujIgumane.repository.korisnik;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.putujIgumane.model.korisnik.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	Korisnik findById(Long id);
	
	Korisnik findByUsername(String username);
	
	@Query("SELECT k FROM Korisnik k WHERE concat(k.ime,' ',k.prezime) LIKE %?1% AND k.username!=?2")
	Page<Korisnik> searchByFullName(String s,String loggedUser,Pageable pageable);
}

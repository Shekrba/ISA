package isa.putujIgumane.repository.korisnik;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.korisnik.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}

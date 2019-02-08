package isa.putujIgumane.repository.korisnik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.putujIgumane.model.korisnik.Rezervacija;

public interface RezervacijaRepository  extends JpaRepository<Rezervacija, Long>{
	

}

package isa.putujIgumane.repository.aviokompanija;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.putujIgumane.model.avioKompanija.Karta;
import isa.putujIgumane.model.avioKompanija.Let;

public interface KartaRepository extends JpaRepository<Karta, Integer> {

	@Query("FROM Karta k WHERE k.popust>0 AND k.kupljena=false")
	List<Karta> findAllForBrza();
	
}

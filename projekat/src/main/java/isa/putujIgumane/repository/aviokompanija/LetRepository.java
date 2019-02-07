package isa.putujIgumane.repository.aviokompanija;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;

public interface LetRepository extends JpaRepository<Let, Long>{
	
	List<Let> findByAvioKompanija(AvioKompanija ak);
	
}

package isa.putujIgumane.repository.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface StatusVozilaRepository  extends JpaRepository<StatusVozila, Long> {

	HashSet<StatusVozila> findByVozilo(Vozilo vozilo);
	
	@Query("select sv from StatusVozila sv where sv.vozilo.id=?1 and datum>=?2 and datum<=?3")
	List<StatusVozila> findInDateByVozilo(Long voziloId, LocalDate from, LocalDate to);
}
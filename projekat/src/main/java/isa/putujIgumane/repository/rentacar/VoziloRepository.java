package isa.putujIgumane.repository.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface VoziloRepository  extends JpaRepository<Vozilo, Long> {

	@Query("SELECT DISTINCT v FROM Vozilo v JOIN FETCH v.statusVozila sv WHERE v.rentACar.id=?1 AND sv.datum>=?2 AND sv.datum<=?3 AND sv.voziloJeIznajmljeno=false GROUP BY v HAVING COUNT(v)=?4")
	List<Vozilo> findFreeVozila(Long rentacarId, LocalDate from, LocalDate to, Long days);
	
	HashSet<Vozilo> findByRentACar(RentACar rentacar);

}
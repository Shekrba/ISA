package isa.putujIgumane.repository.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface VoziloRepository  extends JpaRepository<Vozilo, Long> {

	@Query("SELECT DISTINCT v FROM Vozilo v JOIN FETCH v.statusVozila sv WHERE v.rentACar.id=?1 AND sv.datum>=?2 AND sv.datum<=?3 AND sv.voziloJeIznajmljeno=false GROUP BY v HAVING COUNT(v)=?4")
	List<Vozilo> findFreeVozila(Long rentacarId, LocalDate from, LocalDate to, Long days);
	
	HashSet<Vozilo> findByRentACar(RentACar rentacar);

	@Query("select distinct v from Vozilo v LEFT OUTER JOIN v.rezervacije r WHERE v.rentACar.id=?1 AND r.otkazano=false AND r.datumOdlaska>=?2")
	List<Vozilo> findRezVozila(Long rentacarId, LocalDate today);

	Vozilo findOneById(Long id);
	
	@Query("select sum(r.ukupnaCena) from Vozilo v LEFT OUTER JOIN v.rezervacije r WHERE v.rentACar.id=?1 AND r.otkazano=false AND r.datum>=?2 AND r.datum<=?3")
	Double findPrihodiRentacar(Long rentacarId, LocalDate from, LocalDate to);
	
	@Query("select distinct v from Vozilo v LEFT OUTER JOIN v.statusVozila sv WHERE sv.voziloJeIznajmljeno=false and sv.cena>=?1 and sv.cena<=?2 and sv.datum>=?3 and sv.datum<=?4 and v.brojSedista=?5 and sv.popust=0 GROUP BY v HAVING COUNT(v)=?6")
	List<Vozilo> findVozilaZaRez(Double cenaFrom, Double cenaTo, LocalDate datumFrom, LocalDate datumTo,int brojSedista, Long days);

	@Query("select distinct v from Vozilo v LEFT OUTER JOIN v.statusVozila sv WHERE sv.voziloJeIznajmljeno=false and sv.datum>=?1 and sv.datum<=?2 and sv.popust>0 GROUP BY v HAVING COUNT(v)=?3")
	List<Vozilo> findVozilaBrza(LocalDate from, LocalDate to, Long days);
}
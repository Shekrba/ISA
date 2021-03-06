package isa.putujIgumane.repository.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

@Repository
public interface StatusSobeRepository extends JpaRepository<StatusSobe, Long> {
	
	HashSet<StatusSobe> findBySoba(Soba soba);
	
	@Query("select ss from StatusSobe ss where ss.soba.id=?1 and datum>=?2 and datum<=?3")
	List<StatusSobe> findInDateBySoba(Long sobaId, LocalDate from, LocalDate to);
	
	@Query("select sum(ss.cena) from StatusSobe ss where ss.soba.id = ?1 and ss.datum>=?2 and ss.datum<=?3 group by ss.cena")
	Double findUkupnaCena(Long sobaId, LocalDate from, LocalDate to);
	
	@Query("select ss from StatusSobe ss where ss.soba.id = ?1 and ss.datum>=?2 and ss.datum<=?3")
	HashSet<StatusSobe> findFromTo(Long sobaId, LocalDate from, LocalDate to);
	
	@Query("select ss.popust from StatusSobe ss where ss.soba.id = ?1 and ss.datum=?2")
	Short findPopust(Long sobaId, LocalDate from);
}

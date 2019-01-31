package isa.putujIgumane.repository.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Long> {
	
	@Query("SELECT DISTINCT s FROM Soba s LEFT OUTER JOIN s.statusSobe ss WHERE s.hotel.id=?1 AND ss.datum>=?2 AND ss.datum<=?3 AND ss.zauzeto=false GROUP BY s HAVING COUNT(s)=?4")
	List<Soba> findFreeSobe(Long hotelId, LocalDate from, LocalDate to,Long days);
	
	HashSet<Soba> findByHotel(Hotel hotel);
	
	@Query("select distinct s from Soba s LEFT OUTER JOIN s.rezervacije r WHERE s.hotel.id=?1 AND r.otkazano=false AND r.datumOdlaska>=?2")
	List<Soba> findRezSobe(Long hotelId, LocalDate today);

	Soba findOneById(Long id);
}

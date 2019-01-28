package isa.putujIgumane.repository.hotel;

import java.util.HashSet;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Long> {
	
	@Query("from Soba as s left outer join s.statusSobe as ss where s.hotel.id = ?1 and ss.zauzeto = false and ss.datum >= ?2 and ss.datum <= ?3")
	List<Soba> findFreeSobe(Long hotelId, LocalDate from, LocalDate to);
	
	HashSet<Soba> findByHotel(Hotel hotel);
}

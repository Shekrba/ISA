package isa.putujIgumane.repository.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Long> {
	
	@Query("SELECT DISTINCT s FROM Soba s JOIN FETCH s.statusSobe ss WHERE s.hotel.id=?1 AND ss.datum>=?2 AND ss.datum<=?3 AND ss.zauzeto=false")
	List<Soba> findFreeSobe(Long hotelId, LocalDate from, LocalDate to);
	
	HashSet<Soba> findByHotel(Hotel hotel);
}

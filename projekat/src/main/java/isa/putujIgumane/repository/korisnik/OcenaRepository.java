package isa.putujIgumane.repository.korisnik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {
	
	List<Ocena> findByHotel(Hotel hotel);
	List<Ocena> findBySoba(Soba soba);
}

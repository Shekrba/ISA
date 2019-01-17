package isa.putujIgumane.repository.hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Long> {
	
	List<Soba> findByHotel(Hotel hotel);
}

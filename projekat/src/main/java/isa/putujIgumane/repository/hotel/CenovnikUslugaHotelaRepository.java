package isa.putujIgumane.repository.hotel;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;

@Repository
public interface CenovnikUslugaHotelaRepository  extends JpaRepository<CenovnikUslugaHotela, Long> {
	Page<CenovnikUslugaHotela> findAll(Pageable pageable);
	
	List<CenovnikUslugaHotela> findByHotel(Hotel hotel);
}

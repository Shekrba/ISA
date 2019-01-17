package isa.putujIgumane.repository.hotel;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;

@Repository
public interface CenovnikUslugaHotelaRepository  extends JpaRepository<CenovnikUslugaHotela, Long> {
	
	HashSet<CenovnikUslugaHotela> findByHotel(Hotel hotel);
}

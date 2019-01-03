package isa.putujIgumane.repository.hotel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.hotel.Hotel;



public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Page<Hotel> findAll(Pageable pageable);
}

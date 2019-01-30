package isa.putujIgumane.repository.hotel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Hotel;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Page<Hotel> findAll(Pageable pageable);
	
	Hotel findOneById(Long id);

}

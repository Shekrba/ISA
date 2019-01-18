package isa.putujIgumane.repository.rentacar;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.RentACar;

@Repository
public interface RentACarRepository extends JpaRepository<RentACar, Long> {
	
	Page<RentACar> findAll(Pageable pageable);
	
	RentACar findOneById(Long id);
}
package isa.putujIgumane.repository.rentacar;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;

@Repository
public interface FilijalaRepository  extends JpaRepository<Filijala, Long> {

	HashSet<Filijala> findByRentACar(RentACar rentacar);
	Filijala findOneById(Long id);
}

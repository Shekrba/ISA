package isa.putujIgumane.repository.rentacar;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface VoziloRepository  extends JpaRepository<Vozilo, Long> {

	HashSet<Vozilo> findByRentACar(RentACar rentacar);

}
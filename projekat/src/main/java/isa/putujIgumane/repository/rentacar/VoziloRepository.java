package isa.putujIgumane.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface VoziloRepository  extends JpaRepository<Vozilo, Long> {

}
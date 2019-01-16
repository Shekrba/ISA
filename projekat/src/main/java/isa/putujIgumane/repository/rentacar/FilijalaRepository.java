package isa.putujIgumane.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.Filijala;

@Repository
public interface FilijalaRepository  extends JpaRepository<Filijala, Long> {

}

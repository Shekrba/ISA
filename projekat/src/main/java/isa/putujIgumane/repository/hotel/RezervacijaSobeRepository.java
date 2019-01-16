package isa.putujIgumane.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.RezervacijaSobe;

@Repository
public interface RezervacijaSobeRepository extends JpaRepository<RezervacijaSobe, Long> {

}

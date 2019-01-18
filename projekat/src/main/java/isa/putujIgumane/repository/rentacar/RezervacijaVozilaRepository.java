package isa.putujIgumane.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.RezervacijaVozila;


@Repository
public interface RezervacijaVozilaRepository  extends JpaRepository<RezervacijaVozila, Long> {

}
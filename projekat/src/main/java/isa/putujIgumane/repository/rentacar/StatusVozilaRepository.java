package isa.putujIgumane.repository.rentacar;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;

@Repository
public interface StatusVozilaRepository  extends JpaRepository<StatusVozila, Long> {

	HashSet<StatusVozila> findByVozilo(Vozilo vozilo);

}
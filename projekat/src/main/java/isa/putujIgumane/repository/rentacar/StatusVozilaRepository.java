package isa.putujIgumane.repository.rentacar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.rentACar.StatusVozila;

@Repository
public interface StatusVozilaRepository  extends JpaRepository<StatusVozila, Long> {

}
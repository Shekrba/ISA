package isa.putujIgumane.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Soba;

@Repository
public interface SobaRepository extends JpaRepository<Soba, Long> {

}

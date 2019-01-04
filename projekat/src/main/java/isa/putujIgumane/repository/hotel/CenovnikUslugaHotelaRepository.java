package isa.putujIgumane.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;

@Repository
public interface CenovnikUslugaHotelaRepository  extends JpaRepository<CenovnikUslugaHotela, Long> {

}

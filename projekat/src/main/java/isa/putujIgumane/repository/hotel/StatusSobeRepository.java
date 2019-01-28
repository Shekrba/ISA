package isa.putujIgumane.repository.hotel;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

@Repository
public interface StatusSobeRepository extends JpaRepository<StatusSobe, Long> {
	
	HashSet<StatusSobe> findBySoba(Soba soba);
}

package isa.putujIgumane.repository.aviokompanija;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;

@Repository
public interface AvioKompanijaRepository extends JpaRepository<AvioKompanija, Long>{

	public Page<AvioKompanija> findAll(Pageable pageable);
	public List<AvioKompanija> findAll();
}

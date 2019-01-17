package isa.putujIgumane.repository.aviokompanija;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;


public interface AviokompanijaRepository extends JpaRepository<AvioKompanija, Long>{

	public Page<AvioKompanija> findAll(Pageable pageable);
	
}

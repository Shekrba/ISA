package isa.putujIgumane.service.aviokompanija;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;

@Service
public interface AvioKompanijaService {

	

	public abstract Page<AvioKompanija> getAll(Pageable pageable);
	
}

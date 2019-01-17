package isa.putujIgumane.service.aviokompanija;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;

public interface AvioKompanijaService {

	public abstract Page<AvioKompanija> getAll();

	public abstract Page<AvioKompanija> getAll(Pageable pageable);
	
}

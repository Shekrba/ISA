package isa.putujIgumane.service.aviokompanija;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;

@Service
public interface AvioKompanijaService {

	public abstract Page<AvioKompanija> getAll(Pageable pageable);
	public abstract AvioKompanija editAk(AvioKompanija ak);
	public abstract AvioKompanija addAvio(AvioKompanijaDTO avio);
	public abstract List<AvioKompanija> getAllNull();
}

package isa.putujIgumane.service.aviokompanija;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;


public interface AvioKompanijaService {

	public Page<AvioKompanija> getAll(Pageable pageable);
	public AvioKompanija editAk(AvioKompanija ak);

	public Let addLet(Let l,Integer akID);
	public List<Let> getAllAKLet(Integer akID);

	public AvioKompanija addAvio(AvioKompanijaDTO avio);
	public List<AvioKompanija> getAllNull();

}

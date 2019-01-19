package isa.putujIgumane.service.aviokompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.repository.aviokompanija.AvioKompanijaRepository;

@Service
public class AvioKompanijaServiceImpl implements AvioKompanijaService{

	@Autowired 
	AvioKompanijaRepository avioKompRepo; 
	
	@Override
	public Page<AvioKompanija> getAll(Pageable pageable) {
		return avioKompRepo.findAll(pageable);
	}

	
	
}

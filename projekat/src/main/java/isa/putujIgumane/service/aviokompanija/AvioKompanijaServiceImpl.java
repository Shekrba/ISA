package isa.putujIgumane.service.aviokompanija;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;
import isa.putujIgumane.repository.aviokompanija.AvioKompanijaRepository;
import isa.putujIgumane.repository.aviokompanija.LetRepository;

@Service
public class AvioKompanijaServiceImpl implements AvioKompanijaService{

	@Autowired 
	AvioKompanijaRepository avioKompRepo; 
	
	@Autowired 
	LetRepository letRepo; 
	
	@Override
	public Page<AvioKompanija> getAll(Pageable pageable) {
		return avioKompRepo.findAll(pageable);
	}

	@Override
	public AvioKompanija editAk(AvioKompanija ak) {
		AvioKompanija ak1=avioKompRepo.findOne(ak.getId());
		ak.setAdmin(ak1.getAdmin());
		return avioKompRepo.save(ak);
	}

	@Override
	public Let addLet(Let l,Integer akID) {
		AvioKompanija ak=avioKompRepo.findOne(akID);
		l.setAvioKompanija(ak);
		return letRepo.save(l);
	}

	@Override
	public List<Let> getAllAKLet(Integer akID) {
		return letRepo.findByAvioKompanija(avioKompRepo.getOne(akID));
	}

	
	
}

package isa.putujIgumane.service.aviokompanija;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Karta;
import isa.putujIgumane.model.avioKompanija.Let;

import isa.putujIgumane.model.hotel.Hotel;

import isa.putujIgumane.model.korisnik.Ocena;


public interface AvioKompanijaService {
	
	public List<AvioKompanija> getAllAvio();

	public Page<AvioKompanija> getAll(Pageable pageable);
	public AvioKompanija editAk(AvioKompanija ak);


	public  Let addLet(Let l,Integer akID);
	public  List<Let> getAllAKLet(Integer akID);
	
	public  List<Let> getAllLet();

	public AvioKompanija addAvio(AvioKompanijaDTO avio);
	public  List<AvioKompanija> getAllNull();
	
	public Let getLet(Long id);
	
	public List<Karta> getForBrza();
	
	public List<Ocena> getOceneAK(AvioKompanija ak);
	public List<Ocena> getOceneLet(Let let);

}

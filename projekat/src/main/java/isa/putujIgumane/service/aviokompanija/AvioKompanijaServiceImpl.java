package isa.putujIgumane.service.aviokompanija;



import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Karta;
import isa.putujIgumane.model.avioKompanija.Let;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.repository.aviokompanija.AvioKompanijaRepository;
import isa.putujIgumane.repository.aviokompanija.KartaRepository;
import isa.putujIgumane.repository.aviokompanija.LetRepository;
import isa.putujIgumane.repository.korisnik.OcenaRepository;

@Transactional(readOnly = true)
@Service
public class AvioKompanijaServiceImpl implements AvioKompanijaService{

	@Autowired 
	AvioKompanijaRepository avioKompRepo; 
	
	@Autowired 
	LetRepository letRepo; 
	
	@Autowired 
	KartaRepository kartaRepo; 
	
	@Autowired
	OcenaRepository ocenaRepository;
	
	@Override
	public Page<AvioKompanija> getAll(Pageable pageable) {
		return avioKompRepo.findAll(pageable);
	}
	
	@Override
	public List<AvioKompanija> getAllAvio(){
		return avioKompRepo.findAll();
	}

	@Transactional(readOnly=false)
	@Override
	public AvioKompanija editAk(AvioKompanija ak) {
		AvioKompanija ak1=avioKompRepo.findOne(ak.getId());
		ak.setAdmin(ak1.getAdmin());
		return avioKompRepo.save(ak);
	}

	@Transactional(readOnly=false)
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

	@Transactional(readOnly=false)
	@Override
	public AvioKompanija addAvio(AvioKompanijaDTO avio) {
		AvioKompanija avioNew = new AvioKompanija();

		avioNew.setNaziv(avio.getNaziv());
		avioNew.setAdresa(avio.getAdresa());
		avioNew.setPromotivniOpis(avio.getPromotivniOpis());
		avioNew.setProsecnaOcena(0.0);
		
        avioKompRepo.save(avioNew);
        
        return avioNew;
	}

	
	@Override
	public List<AvioKompanija> getAllNull() {
		
		List<AvioKompanija> avio = avioKompRepo.findAll();
		
		List<AvioKompanija> avioNull = new ArrayList<>();
		
		for (AvioKompanija a : avio) {
			if(a.getAdmin()==null) {
				avioNull.add(a);
			}
		}
		
		return avioNull;
	}

	@Override
	public List<Let> getAllLet() {
		return letRepo.findAll();
	}

	@Override
	public Let getLet(Long id) {
		return letRepo.findOne(id);
	}
	
	@Override
	public List<Karta> getForBrza(){
		return kartaRepo.findAllForBrza();
	}
	
	@Override
	public List<Ocena> getOceneAK(AvioKompanija ak){
		return ocenaRepository.findByAvioKompanija(ak);
	}
	
	@Override
	public List<Ocena> getOceneLet(Let let){
		return ocenaRepository.findByLet(let);
	}
	
}

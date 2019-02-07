package isa.putujIgumane.service.aviokompanija;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.repository.aviokompanija.AvioKompanijaRepository;

@Service
public class AvioKompanijaServiceImpl implements AvioKompanijaService{

	@Autowired 
	AvioKompanijaRepository avioKompRepo; 
	
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
	
}

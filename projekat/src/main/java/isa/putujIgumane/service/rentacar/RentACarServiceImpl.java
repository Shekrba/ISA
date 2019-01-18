package isa.putujIgumane.service.rentacar;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.repository.rentacar.FilijalaRepository;
import isa.putujIgumane.repository.rentacar.RentACarRepository;
import isa.putujIgumane.repository.rentacar.StatusVozilaRepository;
import isa.putujIgumane.repository.rentacar.VoziloRepository;

@Service
public class RentACarServiceImpl implements RentACarService{

	@Autowired
	private RentACarRepository rentACarRepository;
	
	@Autowired
	private FilijalaRepository filijalaRepository;
	
	@Autowired
	private VoziloRepository voziloRepository;
	
	@Autowired
	private StatusVozilaRepository statusVozilaRepository;

	@Override
	public List<RentACar> findAll() {
		List<RentACar> re = rentACarRepository.findAll();
		for (RentACar r : re) {
			r.setFilijale(filijalaRepository.findByRentACar(r));
			
			r.setListaVozila(voziloRepository.findByRentACar(r));
		}
		
		return re;
	}

	@Override
	public RentACar findById(Long id) {
		RentACar r = rentACarRepository.findOneById(id);
		r.setFilijale(filijalaRepository.findByRentACar(r));
		for (Filijala f : r.getFilijale()) {
			f.setRentACar(r);
		}
		r.setListaVozila(voziloRepository.findByRentACar(r));
		for (Vozilo v : r.getListaVozila()) {
			v.setRentACar(r);
		}
		return r;
	}

	@Override
	public HashSet<Vozilo> findVoziloByRentACar(RentACar rentacar) {
		return voziloRepository.findByRentACar(rentacar);
	}

	@Override
	public HashSet<StatusVozila> findStatusByVozilo(Vozilo vozilo) {
		return statusVozilaRepository.findByVozilo(vozilo);
	}

	@Override
	public HashSet<VoziloDTO> getFreeVozilo(RentACar r, Date from, Date to) {
		HashSet<Vozilo> svaVozila = voziloRepository.findByRentACar(r);
		HashSet<VoziloDTO> freeVozila = new HashSet<VoziloDTO>();
		
		for (Vozilo vozilo : svaVozila) {
			HashSet<StatusVozila> statusi = statusVozilaRepository.findByVozilo(vozilo);
			boolean flag = true;
			for (StatusVozila sv : statusi) {
				if((sv.getDatum().after(from) && sv.getDatum().before(to)) || sv.getDatum().equals(from) || sv.getDatum().equals(to)) {
					if(sv.isVoziloJeIznajmljeno()) {
						flag = false;
					}
				}
			}
			
			if(flag) {
				freeVozila.add(new VoziloDTO(vozilo));
			}
				
		}
		return freeVozila;
	}
}

package isa.putujIgumane.service.rentacar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<RentACar> getAll() {

		List<RentACar> rentacari = rentACarRepository.findAll();
		return rentacari;
	}

	@Override
	public RentACar findById(Long id) {
		RentACar rentACar = rentACarRepository.findOneById(id);
		rentACar.setFilijale(filijalaRepository.findByRentACar(rentACar));
		for (Filijala f : rentACar.getFilijale()) {
			f.setRentACar(rentACar);
		}
		rentACar.setListaVozila(voziloRepository.findByRentACar(rentACar));
		for (Vozilo v : rentACar.getListaVozila()) {
			v.setRentACar(rentACar);
		}
		return rentACar;
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
	public List<Vozilo> getFreeVozilo(Long rentacarId, LocalDate from, LocalDate to) {
		
		Long days = ChronoUnit.DAYS.between(from, to) + 1;
		
		return voziloRepository.findFreeVozila(rentacarId, from, to, days);
	}

	}

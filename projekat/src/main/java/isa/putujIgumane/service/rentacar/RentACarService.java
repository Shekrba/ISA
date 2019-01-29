package isa.putujIgumane.service.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;

@Service
public interface RentACarService {

	public abstract List<RentACar> getAll();
	public abstract RentACar findById(Long id);
	public abstract HashSet<Vozilo> findVoziloByRentACar(RentACar rentacar);
	public abstract HashSet<StatusVozila> findStatusByVozilo(Vozilo vozilo);
	public abstract List<Vozilo> getFreeVozilo(Long rentacarId, LocalDate from, LocalDate to);
}

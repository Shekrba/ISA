package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.Vozilo;

@Service
public interface VoziloService {

	public abstract List<Vozilo> findAll();

}
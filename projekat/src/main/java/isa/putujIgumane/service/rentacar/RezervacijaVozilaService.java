package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.RezervacijaVozila;


@Service
public interface RezervacijaVozilaService {

	public abstract List<RezervacijaVozila> findAll();

}
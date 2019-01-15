package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.RezervacijaVozila;
import isa.putujIgumane.repository.rentacar.RezervacijaVozilaRepository;


@Service
public class RezervacijaVozilaServiceImpl implements RezervacijaVozilaService{

	@Autowired
	private RezervacijaVozilaRepository rezervacijaVozilaRepository;

	@Override
	public List<RezervacijaVozila> findAll() {
		return rezervacijaVozilaRepository.findAll();
	}
}
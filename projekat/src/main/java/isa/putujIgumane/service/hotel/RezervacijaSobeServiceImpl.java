package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.repository.hotel.RezervacijaSobeRepository;

@Service
public class RezervacijaSobeServiceImpl implements RezervacijaSobeService {

	@Autowired
	private RezervacijaSobeRepository rezervacijaSobeRepository;
	
	@Override
	public List<RezervacijaSobe> findAll() {
		return rezervacijaSobeRepository.findAll();
	}
	
}

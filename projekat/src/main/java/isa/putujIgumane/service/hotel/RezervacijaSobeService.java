package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.RezervacijaSobe;

@Service
public interface RezervacijaSobeService {

	public abstract List<RezervacijaSobe> findAll();
	
}

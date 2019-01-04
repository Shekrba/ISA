package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.StatusSobe;

@Service
public interface StatusSobeService {

	public abstract List<StatusSobe> findAll();
	
}

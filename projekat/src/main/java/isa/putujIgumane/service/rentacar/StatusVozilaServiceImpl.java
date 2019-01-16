package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.repository.rentacar.StatusVozilaRepository;

@Service
public class StatusVozilaServiceImpl implements StatusVozilaService{

	@Autowired
	private StatusVozilaRepository statusVozilaRepository;

	@Override
	public List<StatusVozila> findAll() {
		return statusVozilaRepository.findAll();
	}
}
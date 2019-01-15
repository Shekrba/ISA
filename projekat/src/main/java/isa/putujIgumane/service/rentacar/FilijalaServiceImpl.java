package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.repository.rentacar.FilijalaRepository;

@Service
public class FilijalaServiceImpl implements FilijalaService{

	@Autowired
	private FilijalaRepository filijalaRepository;

	@Override
	public List<Filijala> findAll() {
		return filijalaRepository.findAll();
	}
}
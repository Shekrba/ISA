package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.repository.rentacar.VoziloRepository;

@Service
public class VoziloServiceImpl implements VoziloService{

	@Autowired
	private VoziloRepository voziloRepository;

	@Override
	public List<Vozilo> findAll() {
		return voziloRepository.findAll();
	}
}
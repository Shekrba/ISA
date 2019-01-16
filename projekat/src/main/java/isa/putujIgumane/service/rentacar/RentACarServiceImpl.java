package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.repository.rentacar.RentACarRepository;

@Service
public class RentACarServiceImpl implements RentACarService{

	@Autowired
	private RentACarRepository rentACarRepository;

	@Override
	public List<RentACar> findAll() {
		return rentACarRepository.findAll();
	}
}

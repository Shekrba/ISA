package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.RentACar;

@Service
public interface RentACarService {

	public abstract List<RentACar> findAll();

}

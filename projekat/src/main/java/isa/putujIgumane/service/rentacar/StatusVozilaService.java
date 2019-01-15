package isa.putujIgumane.service.rentacar;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.rentACar.StatusVozila;


@Service
public interface StatusVozilaService {

	public abstract List<StatusVozila> findAll();

}
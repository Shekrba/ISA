package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;

@Service
public interface CenovnikUslugaHotelaService {
	public abstract List<CenovnikUslugaHotela> findAll();
}

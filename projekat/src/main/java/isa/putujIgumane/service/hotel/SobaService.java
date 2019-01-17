package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;

@Service
public interface SobaService {
	public abstract List<Soba> findAll();
}

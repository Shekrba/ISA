package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.repository.hotel.SobaRepository;

@Service
public class SobaServiceImpl implements SobaService {

	@Autowired
	private SobaRepository sobaRepository;
	
	@Override
	public List<Soba> findAll() {
		return sobaRepository.findAll();
	}
	
}

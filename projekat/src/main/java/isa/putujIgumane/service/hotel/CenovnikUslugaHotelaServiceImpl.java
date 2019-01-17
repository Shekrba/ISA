package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.repository.hotel.CenovnikUslugaHotelaRepository;


@Service
public class CenovnikUslugaHotelaServiceImpl implements CenovnikUslugaHotelaService {

	@Autowired
	private CenovnikUslugaHotelaRepository cenovnikUslugaHotelaRepository;
	
}

package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.StatusSobe;

import isa.putujIgumane.repository.hotel.StatusSobeRepository;

@Service
public class StatusSobeServiceImpl implements StatusSobeService {

	@Autowired
	private StatusSobeRepository statusSobeRepository;
	
	@Override
	public List<StatusSobe> findAll() {
		return statusSobeRepository.findAll();
	}
	
}

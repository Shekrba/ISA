package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.repository.hotel.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
}
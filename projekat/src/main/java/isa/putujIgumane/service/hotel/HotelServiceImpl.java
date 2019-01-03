package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.repository.hotel.HotelRepository;

public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
}

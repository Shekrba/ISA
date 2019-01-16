package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.repository.hotel.CenovnikUslugaHotelaRepository;
import isa.putujIgumane.repository.hotel.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private CenovnikUslugaHotelaRepository cenovnikUslugaHotelaRepository;
	
	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
	
	@Override
	public Hotel findById(Long id) {
		return hotelRepository.findOneById(id);
	}
	
	@Override
	public List<CenovnikUslugaHotela> findByHotel(Hotel hotel) {
		return cenovnikUslugaHotelaRepository.findByHotel(hotel);
	}
}

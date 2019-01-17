package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.repository.hotel.CenovnikUslugaHotelaRepository;
import isa.putujIgumane.repository.hotel.HotelRepository;
import isa.putujIgumane.repository.hotel.SobaRepository;
import isa.putujIgumane.repository.hotel.StatusSobeRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private CenovnikUslugaHotelaRepository cenovnikUslugaHotelaRepository;
	@Autowired
	private SobaRepository sobaRepository;
	@Autowired
	private StatusSobeRepository statusSobeReposatory;
	
	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}
	
	@Override
	public Hotel findById(Long id) {
		return hotelRepository.findOneById(id);
	}
	
	@Override
	public List<CenovnikUslugaHotela> findCenovnikByHotel(Hotel hotel) {
		return cenovnikUslugaHotelaRepository.findByHotel(hotel);
	}
	
	@Override
	public List<Soba> findSobeByHotel(Hotel hotel) {
		return sobaRepository.findByHotel(hotel);
	}
	
	@Override
	public List<StatusSobe> findStatusBySoba(Soba soba) {
		return statusSobeReposatory.findBySoba(soba);
	}
}

package isa.putujIgumane.service.hotel;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.StatusSobeDTO;
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
	public List<Hotel> getAll() {
		
		List<Hotel> hoteli = hotelRepository.findAll();
		
		return hoteli;
	}
	
	@Override
	public Hotel findById(Long id) {
		Hotel hotel = hotelRepository.findOneById(id);
		hotel.setCenovnikUsluga(cenovnikUslugaHotelaRepository.findByHotel(hotel));
		for (CenovnikUslugaHotela cuh : hotel.getCenovnikUsluga()) {
			cuh.setHotel(hotel);
		}
		hotel.setSobe(sobaRepository.findByHotel(hotel));
		for (Soba s : hotel.getSobe()) {
			s.setHotel(hotel);
		}
		return hotel;
	}
	
	@Override
	public HashSet<Soba> findSobeByHotel(Hotel hotel) {
		return sobaRepository.findByHotel(hotel);
	}
	
	@Override
	public HashSet<StatusSobe> findStatusBySoba(Soba soba) {
		return statusSobeReposatory.findBySoba(soba);
	}
	
	@Override
	public List<Soba> getFreeSoba(Long hotelId, LocalDate from, LocalDate to){
		
		return sobaRepository.findFreeSobe(hotelId, from, to);
	}
}

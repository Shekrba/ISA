package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;


@Service
public interface HotelService {
	
	public abstract List<Hotel> findAll();
	public abstract Hotel findById(Long id);
	public abstract List<CenovnikUslugaHotela> findByHotel(Hotel hotel);
}

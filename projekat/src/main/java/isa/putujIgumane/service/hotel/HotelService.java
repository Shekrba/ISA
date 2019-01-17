package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;


@Service
public interface HotelService {
	
	public abstract List<Hotel> findAll();
	public abstract Hotel findById(Long id);
	public abstract List<CenovnikUslugaHotela> findCenovnikByHotel(Hotel hotel);
	public abstract List<Soba> findSobeByHotel(Hotel hotel);
	public abstract List<StatusSobe> findStatusBySoba(Soba soba);
}

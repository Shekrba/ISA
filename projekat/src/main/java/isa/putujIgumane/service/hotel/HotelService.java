package isa.putujIgumane.service.hotel;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;


@Service
public interface HotelService {
	
	public abstract List<Hotel> getAll();
	public abstract Hotel findById(Long id);
	public abstract HashSet<Soba> findSobeByHotel(Hotel hotel);
	public abstract HashSet<StatusSobe> findStatusBySoba(Soba soba);
	public abstract List<Soba> getFreeSoba(Long hotelId, LocalDate from, LocalDate to);
	public abstract Hotel update(HotelDTO hotel) throws Exception;
}

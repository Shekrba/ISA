package isa.putujIgumane.service.hotel;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;


@Service
public interface HotelService {
	
	public abstract List<Hotel> findAll();
	public abstract Hotel findById(Long id);
	public abstract HashSet<Soba> findSobeByHotel(Hotel hotel);
	public abstract HashSet<StatusSobe> findStatusBySoba(Soba soba);
	public abstract HashSet<SobaDTO> getFreeSoba(Hotel h, Date from, Date to);
}

package isa.putujIgumane.service.hotel;

import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.model.hotel.Hotel;


@Service
public interface HotelService {
	
	public abstract List<Hotel> findAll();

}

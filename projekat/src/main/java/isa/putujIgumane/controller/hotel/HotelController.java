package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.service.hotel.HotelServiceImpl;

@RestController
@RequestMapping(value="api/hoteli")
public class HotelController {
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HotelDTO>> getAllHotels() {
		
		List<Hotel> hoteli = hotelServiceImpl.findAll();
		
		List<HotelDTO> hoteliDTO = new ArrayList<>();
		for (Hotel h : hoteli) {
			hoteliDTO.add(new HotelDTO(h));
		}
		
		return new ResponseEntity<>(hoteliDTO, HttpStatus.OK);
	}
}

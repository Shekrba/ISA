package isa.putujIgumane.controller.hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.StatusSobeDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.service.hotel.CenovnikUslugaHotelaServiceImpl;
import isa.putujIgumane.service.hotel.HotelServiceImpl;
import scala.annotation.meta.setter;

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
	
	@RequestMapping(value="/{id}/{from}/{to}", method=RequestMethod.GET)
	public ResponseEntity<HotelDTO> getHotel(@PathVariable("id")Long id,@PathVariable("from")String from,@PathVariable("to")String to){
		
		Hotel hotel = hotelServiceImpl.findById(id);
		
		if(hotel == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		HotelDTO hotelDTO = new HotelDTO(hotel);
		
		try {
			DateFormat format = new SimpleDateFormat("yyyy-dd-MM");
			Date fromDate = format.parse(from);
			Date toDate = format.parse(to);
			
			HashSet<SobaDTO> freeSobe = hotelServiceImpl.getFreeSoba(hotel, fromDate, toDate);
			hotelDTO.setSobe(freeSobe);
		}catch (Exception e) {
			hotelDTO.setSobe(new HashSet<SobaDTO>());
		}
		
		return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
	}
}

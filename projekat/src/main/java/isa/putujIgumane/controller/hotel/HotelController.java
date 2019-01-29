package isa.putujIgumane.controller.hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.mapping.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
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
import isa.putujIgumane.utils.ObjectMapperUtils;
import scala.annotation.meta.setter;

@RestController
@RequestMapping(value="api/hoteli", produces="application/json;charset=UTF-8")
public class HotelController {
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllHotels() {
		
		List<HotelDTO> hoteliDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getAll(), HotelDTO.class);

		return new ResponseEntity<>(hoteliDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<HotelDTO> getHotel(@PathVariable("id")Long id){
		
		Hotel hotel = hotelServiceImpl.findById(id);
		
		if(hotel == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		HotelDTO hotelDTO=ObjectMapperUtils.map(hotelServiceImpl.findById(id), HotelDTO.class);
		
		return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/freeRooms/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getFreeRooms(@PathVariable("id")Long id,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
		
			
			List<SobaDTO> freeSobeDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getFreeSoba(id, fromDate, toDate), SobaDTO.class);
			return new ResponseEntity<>(freeSobeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editHotel", method=RequestMethod.PUT)
	public ResponseEntity<?> updateHotel(@RequestBody HotelDTO hotel){
		
		Hotel updatedHotel = null;
		
		try {
			updatedHotel = hotelServiceImpl.update(hotel);
		} catch (Exception e) {
			return new ResponseEntity<Hotel>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
	}
}

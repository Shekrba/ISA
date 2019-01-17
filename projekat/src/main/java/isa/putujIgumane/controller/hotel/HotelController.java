package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<HotelDTO> getHotel(@PathVariable("id")Long id){
		System.out.println("ULAZI");
		Hotel hotel = hotelServiceImpl.findById(id);
		
		// studen must exist
		if(hotel == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<CenovnikUslugaHotela> cenovnici = hotelServiceImpl.findCenovnikByHotel(hotel);
		HashSet<CenovnikUslugaHotelaDTO> cenovniciDTO = new HashSet<CenovnikUslugaHotelaDTO>();
			
		for (CenovnikUslugaHotela c : cenovnici) {
			cenovniciDTO.add(new CenovnikUslugaHotelaDTO(c));
		}
		
		
		List<Soba> sobe = hotelServiceImpl.findSobeByHotel(hotel);
		HashSet<SobaDTO> sobeDTO = new HashSet<SobaDTO>();
		
		for (Soba s : sobe) {
			
			List<StatusSobe> statusiSobe = hotelServiceImpl.findStatusBySoba(s);
			HashSet<StatusSobeDTO> statusiSobeDTO = new HashSet<StatusSobeDTO>();
			
			for (StatusSobe ss : statusiSobe) {
				statusiSobeDTO.add(new StatusSobeDTO(ss));
			}
			
			
			SobaDTO sobaDTO = new SobaDTO(s);
			
			sobaDTO.setStatusSobe(statusiSobeDTO);
			
			sobeDTO.add(sobaDTO);
		}
		
				
		HotelDTO hotelDTO = new HotelDTO(hotel);
		hotelDTO.setCenovnikUsluga(cenovniciDTO);
		hotelDTO.setSobe(sobeDTO);
		
		return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
	}
}

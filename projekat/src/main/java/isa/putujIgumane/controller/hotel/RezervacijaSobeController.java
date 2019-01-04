package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.RezervacijaSobeDTO;
import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.service.hotel.RezervacijaSobeServiceImpl;

@RestController
@RequestMapping(value="api/rezervacijeSoba")
public class RezervacijaSobeController {

	@Autowired
	private RezervacijaSobeServiceImpl rezervacijaSobeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RezervacijaSobeDTO>> getAllRezervacijaSobe() {
		
		List<RezervacijaSobe> rezervacije = rezervacijaSobeServiceImpl.findAll();
		
		List<RezervacijaSobeDTO> rezervacijeDTO = new ArrayList<>();
		for (RezervacijaSobe r : rezervacije) {
			rezervacijeDTO.add(new RezervacijaSobeDTO(r));
		}
		
		return new ResponseEntity<>(rezervacijeDTO, HttpStatus.OK);
	}
	
}

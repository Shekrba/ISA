package isa.putujIgumane.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.RezervacijaVozilaDTO;
import isa.putujIgumane.model.rentACar.RezervacijaVozila;
import isa.putujIgumane.service.rentacar.RezervacijaVozilaServiceImpl;


@RestController
@RequestMapping(value="api/rezervacijaVozila")
public class RezervacijaVozilaController {
	@Autowired
	private RezervacijaVozilaServiceImpl rezervacijaVozilaServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RezervacijaVozilaDTO>> getAllRezervacijeVozila() {
		
		List<RezervacijaVozila> rezervacijeVozila = rezervacijaVozilaServiceImpl.findAll();
		
		List<RezervacijaVozilaDTO> rezervacijeVozilaDTO = new ArrayList<>();
		for (RezervacijaVozila r : rezervacijeVozila) {
			rezervacijeVozilaDTO.add(new RezervacijaVozilaDTO(r));
		}
		
		return new ResponseEntity<>(rezervacijeVozilaDTO, HttpStatus.OK);
	}
}
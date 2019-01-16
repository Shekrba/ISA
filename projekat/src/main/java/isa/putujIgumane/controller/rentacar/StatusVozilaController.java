package isa.putujIgumane.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.StatusVozilaDTO;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.service.rentacar.StatusVozilaServiceImpl;


@RestController
@RequestMapping(value="api/statusiVozila")
public class StatusVozilaController {
	@Autowired
	private StatusVozilaServiceImpl statusVozilaServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusVozilaDTO>> getAllStatusiVozila() {
		
		List<StatusVozila> statusiVozila = statusVozilaServiceImpl.findAll();
		
		List<StatusVozilaDTO> statusiVozilaDTO = new ArrayList<>();
		for (StatusVozila s : statusiVozila) {
			statusiVozilaDTO.add(new StatusVozilaDTO(s));
		}
		
		return new ResponseEntity<>(statusiVozilaDTO, HttpStatus.OK);
	}
}
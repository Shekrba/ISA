package isa.putujIgumane.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.FilijalaDTO;
import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.service.rentacar.FilijalaServiceImpl;

@RestController
@RequestMapping(value="api/filijale")
public class FilijalaController {
	@Autowired
	private FilijalaServiceImpl filijalaServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FilijalaDTO>> getAllFilijale() {
		
		List<Filijala> filijale = filijalaServiceImpl.findAll();
		
		List<FilijalaDTO> filijaleDTO = new ArrayList<>();
		for (Filijala f : filijale) {
			filijaleDTO.add(new FilijalaDTO(f));
		}
		
		return new ResponseEntity<>(filijaleDTO, HttpStatus.OK);
	}
}

package isa.putujIgumane.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.service.rentacar.VoziloServiceImpl;

@RestController
@RequestMapping(value="api/vozila")
public class VoziloController {
	@Autowired
	private VoziloServiceImpl voziloServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VoziloDTO>> getAllVozila() {
		
		List<Vozilo> vozila = voziloServiceImpl.findAll();
		
		List<VoziloDTO> vozilaDTO = new ArrayList<>();
		for (Vozilo v : vozila) {
			vozilaDTO.add(new VoziloDTO(v));
		}
		
		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK);
	}
}
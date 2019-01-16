package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.service.hotel.SobaServiceImpl;

@RestController
@RequestMapping(value="api/sobe")
public class SobaController {

	@Autowired
	private SobaServiceImpl sobaServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SobaDTO>> getAllSobe() {
		
		List<Soba> sobe = sobaServiceImpl.findAll();
		
		List<SobaDTO> sobeDTO = new ArrayList<>();
		for (Soba s : sobe) {
			sobeDTO.add(new SobaDTO(s));
		}
		
		return new ResponseEntity<>(sobeDTO, HttpStatus.OK);
	}
	
}

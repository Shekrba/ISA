package isa.putujIgumane.controller.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import isa.putujIgumane.dto.hotel.StatusSobeDTO;

import isa.putujIgumane.model.hotel.StatusSobe;

import isa.putujIgumane.service.hotel.StatusSobeServiceImpl;

@RestController
@RequestMapping(value="api/statusiSoba")
public class StatusSobeController {
	@Autowired
	private StatusSobeServiceImpl statusSobeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusSobeDTO>> getAllStatusSobe() {
		
		List<StatusSobe> statusiSoba = statusSobeServiceImpl.findAll();
		
		List<StatusSobeDTO> statusiSobaDTO = new ArrayList<>();
		for (StatusSobe s : statusiSoba) {
			statusiSobaDTO.add(new StatusSobeDTO(s));
		}
		
		return new ResponseEntity<>(statusiSobaDTO, HttpStatus.OK);
	}
}

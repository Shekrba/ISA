package isa.putujIgumane.controller.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.RentACarDTO;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.service.rentacar.RentACarServiceImpl;

@RestController
@RequestMapping(value="api/rentacar")
public class RentACarController {
	@Autowired
	private RentACarServiceImpl rentACarServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RentACarDTO>> getAllRentACars() {
		
		List<RentACar> rentacars = rentACarServiceImpl.findAll();
		
		List<RentACarDTO> rentacarsDTO = new ArrayList<>();
		for (RentACar r : rentacars) {
			rentacarsDTO.add(new RentACarDTO(r));
		}
		
		return new ResponseEntity<>(rentacarsDTO, HttpStatus.OK);
	}
}

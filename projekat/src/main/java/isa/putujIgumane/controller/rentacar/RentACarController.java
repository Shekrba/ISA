package isa.putujIgumane.controller.rentacar;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.rentacar.RentACarDTO;
import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.service.rentacar.RentACarServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;

@RestController
@RequestMapping(value="api/rentacar", produces="application/json;charset=UTF-8")
public class RentACarController {
	@Autowired
	private RentACarServiceImpl rentacarServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllRentACars() {
		
		List<RentACarDTO> rentacariDTO=ObjectMapperUtils.mapAll(rentacarServiceImpl.getAll(), RentACarDTO.class);

		return new ResponseEntity<>(rentacariDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<RentACarDTO> getRentACar(@PathVariable("id")Long id){
		
		RentACar rentacar = rentacarServiceImpl.findById(id);
		
		if(rentacar == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		RentACarDTO rentacarDTO=ObjectMapperUtils.map(rentacarServiceImpl.findById(id), RentACarDTO.class);
		
		return new ResponseEntity<>(rentacarDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/freeCars/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getFreeCars(@PathVariable("id")Long id,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
		
			
			List<VoziloDTO> freeCarsDTO=ObjectMapperUtils.mapAll(rentacarServiceImpl.getFreeVozilo(id, fromDate, toDate), VoziloDTO.class);
			return new ResponseEntity<>(freeCarsDTO, HttpStatus.OK);
	}
}

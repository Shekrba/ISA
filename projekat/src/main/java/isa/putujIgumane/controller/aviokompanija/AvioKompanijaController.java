package isa.putujIgumane.controller.aviokompanija;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.service.aviokompanija.AvioKompanijaServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;



@RestController
@RequestMapping(value="api/aviokompanije")
public class AvioKompanijaController {

	@Autowired AvioKompanijaServiceImpl akService;
	
	@RequestMapping(value="/{pageNumber}", method=RequestMethod.GET)
	public ResponseEntity<List<AvioKompanijaDTO>> getAksPage(@PathVariable("pageNumber") int pageNumber) {
		PageRequest p=new PageRequest(pageNumber-1,5);
		List<AvioKompanijaDTO> akList=ObjectMapperUtils.mapAll(akService.getAll(p).getContent(), AvioKompanijaDTO.class);
		return new ResponseEntity<>(akList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> editAk(@RequestBody AvioKompanijaDTO akDTO) {
		AvioKompanija ak=ObjectMapperUtils.map(akDTO, AvioKompanija.class);
		AvioKompanija ret=akService.editAk(ak);
		return new ResponseEntity<AvioKompanijaDTO>(ObjectMapperUtils.map(ret, AvioKompanijaDTO.class),HttpStatus.OK);
	}
	
}

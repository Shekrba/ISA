package isa.putujIgumane.controller.aviokompanija;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.aviokompanija.AdresaDTO;
import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.aviokompanija.LetDTO;
import isa.putujIgumane.dto.aviokompanija.SegmentDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;
import isa.putujIgumane.model.avioKompanija.Segment;
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
	
	@RequestMapping(value="/new/flight", method=RequestMethod.GET)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> getNewFlight() {
		LetDTO letDTO=new LetDTO();
		letDTO.setSegmenti(new HashSet<SegmentDTO>());
		letDTO.setVremePoletanja(LocalDateTime.now());
		letDTO.setVremeSletanja(LocalDateTime.now());
		letDTO.setPresedanja(new HashSet<AdresaDTO>());
		return new ResponseEntity<LetDTO>(letDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/flights/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> getAllAKFlights(@PathVariable("id") Integer akID) {
		List<LetDTO> letoviDTO=ObjectMapperUtils.mapAll(akService.getAllAKLet(akID), LetDTO.class);
		return new ResponseEntity<List<LetDTO>>(letoviDTO,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/add/flight/{id}", method=RequestMethod.POST)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> addFlight(@RequestBody LetDTO letDTO,@PathVariable("id") Integer akID) {
		Let let=new Let();
		let.setVremePoletanja(letDTO.getVremePoletanja());
		let.setVremeSletanja(letDTO.getVremeSletanja());
		Duration d=Duration.between(let.getVremePoletanja(), let.getVremeSletanja());
		let.setVremePutovanja(d);
		let.setDuzinaPutovanja(100);
		let.setSegmenti(new HashSet<Segment>(ObjectMapperUtils.mapAll(letDTO.getSegmenti(), Segment.class)));
		akService.addLet(let, akID);
		return new ResponseEntity<String>("Let je uspesno kreiran",HttpStatus.OK);
	}
	
}

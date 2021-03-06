package isa.putujIgumane.controller.aviokompanija;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
import isa.putujIgumane.dto.aviokompanija.KartaDTO;
import isa.putujIgumane.dto.aviokompanija.LetDTO;
import isa.putujIgumane.dto.aviokompanija.SegmentDTO;
import isa.putujIgumane.model.avioKompanija.Adresa;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Karta;
import isa.putujIgumane.model.avioKompanija.Let;
import isa.putujIgumane.model.avioKompanija.Sediste;
import isa.putujIgumane.model.avioKompanija.Segment;

import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.OcenaHotelaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.service.aviokompanija.AvioKompanijaService;
import isa.putujIgumane.service.aviokompanija.AvioKompanijaServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;



@RestController
@RequestMapping(value="api/aviokompanije")
public class AvioKompanijaController {

	@Autowired AvioKompanijaService akService;
	
	@RequestMapping(value="/{pageNumber}", method=RequestMethod.GET)
	public ResponseEntity<List<AvioKompanijaDTO>> getAksPage(@PathVariable("pageNumber") int pageNumber) {
		PageRequest p=new PageRequest(pageNumber-1,5);
		List<AvioKompanijaDTO> akList=ObjectMapperUtils.mapAll(akService.getAll(p).getContent(), AvioKompanijaDTO.class);
		return new ResponseEntity<>(akList, HttpStatus.OK);
		
	}
	

	@RequestMapping(value="/a/b/c/d",method = RequestMethod.GET)
	public ResponseEntity<?> getAllAvio() {
	
		List<AvioKompanijaDTO> avioDTO=ObjectMapperUtils.mapAll(akService.getAllAvio(), AvioKompanijaDTO.class);

		return new ResponseEntity<>(avioDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/hotel/{hotelId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getOceneHotela(@PathVariable("akId")Integer akId){
		
		AvioKompanija ak = new AvioKompanija();
		ak.setId(akId);
		
		List<Ocena> ocene = akService.getOceneAK(ak);
		
		List<OcenaHotelaDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaHotelaDTO ocenaDTO = new OcenaHotelaDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/soba/{sobaId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getOceneSobe(@PathVariable("letId")Long letId){
		
		Let s = new Let();
		s.setId(letId);
		
		List<Ocena> ocene = akService.getOceneLet(s);
		
		List<OcenaHotelaDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaHotelaDTO ocenaDTO = new OcenaHotelaDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
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
		letDTO.setVremePoletanja(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
		letDTO.setVremeSletanja(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
		letDTO.setPresedanja(new HashSet<AdresaDTO>());
		return new ResponseEntity<LetDTO>(letDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/flights/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> getAllAKFlights(@PathVariable("id") Integer akID) {
		List<LetDTO> letoviDTO=ObjectMapperUtils.mapAll(akService.getAllAKLet(akID), LetDTO.class);
		return new ResponseEntity<List<LetDTO>>(letoviDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/karte/brza", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getForBrza() {
		return new ResponseEntity<List<Karta>>(akService.getForBrza(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/add/flight/{id}", method=RequestMethod.POST)
	@PreAuthorize("hasRole('AKADMIN')")
	public ResponseEntity<?> addFlight(@RequestBody LetDTO letDTO,@PathVariable("id") Integer akID) {
		Let let=new Let();
		let.setVremePoletanja(letDTO.getVremePoletanja());
		let.setVremeSletanja(letDTO.getVremeSletanja());
		let.setPresedanja(new HashSet<Adresa>(ObjectMapperUtils.mapAll(letDTO.getPresedanja(), Adresa.class)));
		Duration d=Duration.between(let.getVremePoletanja(), let.getVremeSletanja());
		let.setVremePutovanja(d);
		let.setDuzinaPutovanja(100);
		let.setSegmenti(new HashSet<Segment>());
		for (SegmentDTO s : letDTO.getSegmenti()) {
			Segment seg=new Segment();
			seg.setCena(s.getCena());
			seg.setKolone(s.getKolone());
			seg.setLet(let);
			seg.setPopust(s.getPopust());
			seg.setRbr(s.getRbr());
			seg.setRedovi(s.getRedovi());
			seg.setX(s.getX());
			seg.setY(s.getY());
			seg.setSedista(new HashSet<Sediste>());
			
			for(Short i=0; i<s.getRedovi();i++) {
				for(Short j=0; j<s.getKolone();j++) {
					Sediste sed=new Sediste();
					sed.setRbr((short)(i*s.getKolone()+j));
					sed.setSegment(seg);
					Karta k=new Karta();
					k.setOdMesta(((AdresaDTO)(letDTO.getPresedanja().toArray()[0])).getName());
					System.out.println(letDTO.getPresedanja().size()-1);
					k.setDoMesta(((AdresaDTO)(letDTO.getPresedanja().toArray()[letDTO.getPresedanja().size()-1])).getName());
					k.setVremePoletanja(letDTO.getVremePoletanja());
					k.setVremeSletanja(letDTO.getVremeSletanja());
					k.setKupljena(false);
					k.setPopust(s.getPopust());
					k.setCena(s.getCena());
					sed.setKarta(k);
					k.setSediste(sed);
					seg.getSedista().add(sed);
				}
			}
			let.getSegmenti().add(seg);
		}
		akService.addLet(let, akID);
		return new ResponseEntity<String>("Let je uspesno kreiran",HttpStatus.OK);
	}
	
	@RequestMapping(value="/flights", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getAllFlights() {
		List<LetDTO> letoviDTO=ObjectMapperUtils.mapAll(akService.getAllLet(), LetDTO.class);
		return new ResponseEntity<List<LetDTO>>(letoviDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/flight/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getFlight(@PathVariable("id") Long id) {
		LetDTO letDTO=ObjectMapperUtils.map(akService.getLet(id), LetDTO.class);
		return new ResponseEntity<LetDTO>(letDTO,HttpStatus.OK);
	}
	
	
	

	@RequestMapping(value="/add/aviokompanija", method=RequestMethod.PUT)
	public ResponseEntity<?> addAvio(@RequestBody AvioKompanijaDTO avio){
		
		AvioKompanija addedAvio = null;
		
		try {
			addedAvio = akService.addAvio(avio);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		AvioKompanijaDTO avioDTO=ObjectMapperUtils.map(addedAvio, AvioKompanijaDTO.class);
		
		return new ResponseEntity<>(avioDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/null/a", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHotelsNull() {
		
		List<AvioKompanijaDTO> avioDTO=ObjectMapperUtils.mapAll(akService.getAllNull(), AvioKompanijaDTO.class);
		
		return new ResponseEntity<>(avioDTO, HttpStatus.OK);
	}

}

package isa.putujIgumane.controller.hotel;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.OcenaHotelaDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.SobaZaRezDTO;
import isa.putujIgumane.dto.hotel.SobeBrzaDTO;
import isa.putujIgumane.dto.hotel.StatusSobeDTO;
import isa.putujIgumane.dto.korisnik.AdminHotelaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.repository.hotel.HotelRepository;
import isa.putujIgumane.service.hotel.HotelService;
import isa.putujIgumane.service.hotel.HotelServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;


@RestController
@RequestMapping(value="api/hoteli", produces="application/json;charset=UTF-8")
public class HotelController {
	@Autowired
	private HotelService hotelServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllHotels() {
		
		List<HotelDTO> hoteliDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getAll(), HotelDTO.class);

		return new ResponseEntity<>(hoteliDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/null/h", method = RequestMethod.GET)
	public ResponseEntity<?> getAllHotelsNull() {
		
		List<HotelDTO> hoteliDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getAllNull(), HotelDTO.class);
		
		return new ResponseEntity<>(hoteliDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getHotel(@PathVariable("id")Long id){
		
		Hotel hotel = hotelServiceImpl.findById(id);
		
		if(hotel == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		HotelDTO hotelDTO=ObjectMapperUtils.map(hotelServiceImpl.findById(id), HotelDTO.class);
		
		return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/freeRooms/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getFreeRooms(@PathVariable("id")Long id,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
		
			
			List<SobaDTO> freeSobeDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getFreeSoba(id, fromDate, toDate), SobaDTO.class);
			return new ResponseEntity<>(freeSobeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editHotel", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> updateHotel(@RequestBody HotelDTO hotel){
		
		Hotel updatedHotel = null;
		
		try {
			updatedHotel = hotelServiceImpl.update(hotel);
		} catch (Exception e) {
			return new ResponseEntity<Hotel>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/cenovnik/{hotelId}", method=RequestMethod.GET)
	public ResponseEntity<?> getCenovnik(@PathVariable("hotelId")Long hotelId){
		
		HashSet<CenovnikUslugaHotela> cuh = hotelServiceImpl.getCenovnik(hotelId);
		
		List<CenovnikUslugaHotelaDTO> cuhDTO = ObjectMapperUtils.mapAll(cuh, CenovnikUslugaHotelaDTO.class);
		
		return new ResponseEntity<>(cuhDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/editUsluga/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getUsluga(@PathVariable("id")Long id){
		
		CenovnikUslugaHotela cuh = hotelServiceImpl.getUsluga(id);
		
		if(cuh == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		CenovnikUslugaHotelaDTO cuhDTO=ObjectMapperUtils.map(cuh, CenovnikUslugaHotelaDTO.class);
		
		return new ResponseEntity<>(cuhDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateUsluga", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> updateCenovnik(@RequestBody CenovnikUslugaHotelaDTO cuh){
		
		CenovnikUslugaHotela updatedCuh = null;
		
		try {
			updatedCuh = hotelServiceImpl.updateCenovnik(cuh);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<>(updatedCuh, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addUsluga/{hotelId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> addCenovnik(@PathVariable("hotelId")Long hotelId,@RequestBody CenovnikUslugaHotelaDTO cuh){
		
		CenovnikUslugaHotela addedCuh = null;
		
		try {
			addedCuh = hotelServiceImpl.addCenovnik(cuh,hotelId);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		CenovnikUslugaHotelaDTO cuhDTO=ObjectMapperUtils.map(addedCuh, CenovnikUslugaHotelaDTO.class);
		
		return new ResponseEntity<>(cuhDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/usluga", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> deleteCenovnik(@RequestParam("id") Long id,@RequestParam("hotelId") Long hotelId) {
		
		HashSet<CenovnikUslugaHotela> cuh = hotelServiceImpl.deleteCenovnik(id,hotelId);
		
		List<CenovnikUslugaHotelaDTO> cuhDTO = ObjectMapperUtils.mapAll(cuh, CenovnikUslugaHotelaDTO.class);
		
		return new ResponseEntity<>(cuhDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/sobe/{hotelId}", method=RequestMethod.GET)
	public ResponseEntity<?> getSobe(@PathVariable("hotelId")Long hotelId){
		
		HashSet<Soba> sobe = hotelServiceImpl.getNerezervisaneSobe(hotelId);
		List<Soba> rezSobe = hotelServiceImpl.getRezervisaneSobe(hotelId);
		
		List<SobaDTO> sobeDTO = ObjectMapperUtils.mapAll(sobe, SobaDTO.class);
		List<SobaDTO> rezSobeDTO = ObjectMapperUtils.mapAll(rezSobe, SobaDTO.class);
		
		List<List<SobaDTO>> sveSobe = new ArrayList<>();
		sveSobe.add(sobeDTO);
		sveSobe.add(rezSobeDTO);
		
		return new ResponseEntity<>(sveSobe, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editSoba/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getSoba(@PathVariable("id")Long id){
		
		Soba soba = hotelServiceImpl.getSoba(id);
		
		if(soba == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		SobaDTO sobaDTO=ObjectMapperUtils.map(soba, SobaDTO.class);
		
		return new ResponseEntity<>(sobaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateSoba", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> updateSoba(@RequestBody SobaDTO soba){
		
		Soba updatedSoba = null;
		
		try {
			updatedSoba = hotelServiceImpl.updateSoba(soba);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<>(updatedSoba, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addSoba/{hotelId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> addSoba(@PathVariable("hotelId")Long hotelId,@RequestBody SobaDTO soba){
		
		Soba addedSoba = null;
		
	
		addedSoba = hotelServiceImpl.addSoba(soba,hotelId);
		
		
		SobaDTO sobaDTO=ObjectMapperUtils.map(addedSoba, SobaDTO.class);
		
		return new ResponseEntity<>(sobaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/soba", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> deleteSoba(@RequestParam("id") Long id,@RequestParam("hotelId") Long hotelId) {
		
		HashSet<Soba> soba = hotelServiceImpl.deleteSoba(id,hotelId);
		
		List<SobaDTO> sobaDTO = ObjectMapperUtils.mapAll(soba, SobaDTO.class);
		
		return new ResponseEntity<>(sobaDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/hotel/{hotelId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getOceneHotela(@PathVariable("hotelId")Long hotelId){
		
		Hotel h = new Hotel();
		h.setId(hotelId);
		
		List<Ocena> ocene = hotelServiceImpl.getOceneHotela(h);
		
		List<OcenaHotelaDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaHotelaDTO ocenaDTO = new OcenaHotelaDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/soba/{sobaId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getOceneSobe(@PathVariable("sobaId")Long sobaId){
		
		Soba s = new Soba();
		s.setId(sobaId);
		
		List<Ocena> ocene = hotelServiceImpl.getOceneSobe(s);
		
		List<OcenaHotelaDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaHotelaDTO ocenaDTO = new OcenaHotelaDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/prihodi/{hotelId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> getPrihode(@PathVariable("hotelId")Long hotelId,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
		
		Double prihodi = hotelServiceImpl.getPrihode(hotelId,fromDate,toDate);
		
		if(prihodi==null)
			prihodi = new Double(0);
		
		return new ResponseEntity<>(prihodi, HttpStatus.OK);
	}
	
	@RequestMapping(value="/setStatusi/{sobaId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('HADMIN')")
	public ResponseEntity<?> setStatuse(@PathVariable("sobaId")Long sobaId, @RequestParam("cena") Double cena,@RequestParam("popust") Short popust,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to){
		
		
		List<StatusSobe> statusiSobe=hotelServiceImpl.setStatuse(sobaId,cena,popust,from,to);
		
		List<StatusSobeDTO> ssDTO = ObjectMapperUtils.mapAll(statusiSobe, StatusSobeDTO.class);
		
		return new ResponseEntity<>(ssDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/sobe/rez", method=RequestMethod.GET)
	public ResponseEntity<?> getSobeZaRez(@RequestParam("hotelId") Long hotelId,@RequestParam("cenaFrom") Double cenaFrom,@RequestParam("cenaTo") Double cenaTo,@RequestParam("datumFrom") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate datumFrom,@RequestParam("datumTo") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate datumTo,@RequestParam("kreveti") List<Boolean> kreveti){
		
		boolean jed = kreveti.get(0);
		boolean dvo = kreveti.get(1);
		boolean tro = kreveti.get(2);
		boolean cet = kreveti.get(3);
		
		List<SobaZaRezDTO> sobeZaRezDTO=ObjectMapperUtils.mapAll(hotelServiceImpl.getSobeZaRez(hotelId,cenaFrom, cenaTo, datumFrom, datumTo,jed,dvo,tro,cet), SobaZaRezDTO.class);
		
		for (SobaZaRezDTO s : sobeZaRezDTO) {
			s.setCena(hotelServiceImpl.getUkupnaCena(s.getId(),datumFrom,datumTo));
		}
		
		return new ResponseEntity<>(sobeZaRezDTO, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/sobe/brza", method=RequestMethod.GET)
	public ResponseEntity<?> getSobeBrza(@RequestParam("hotelId") Long hotelId,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to){
		
		List<SobeBrzaDTO> sobeDTO = hotelServiceImpl.getSobeBrza(hotelId,from,to);		
		
		return new ResponseEntity<>(sobeDTO, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/add/hotel", method=RequestMethod.PUT)
	public ResponseEntity<?> addHotel(@RequestBody HotelDTO hotel){
		
		Hotel addedHotel = null;
		
		try {
			addedHotel = hotelServiceImpl.addHotel(hotel);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		HotelDTO hotelDTO=ObjectMapperUtils.map(addedHotel, HotelDTO.class);
		
		return new ResponseEntity<>(hotelDTO, HttpStatus.OK);
	}
	
}

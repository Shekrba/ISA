package isa.putujIgumane.controller.rentacar;

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

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.rentacar.FilijalaDTO;
import isa.putujIgumane.dto.rentacar.OcenaRentacarDTO;
import isa.putujIgumane.dto.rentacar.RentACarDTO;
import isa.putujIgumane.dto.rentacar.StatusVozilaDTO;
import isa.putujIgumane.dto.rentacar.VozilaBrzaDTO;
import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.dto.rentacar.VoziloZaRezDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.service.rentacar.RentACarService;
import isa.putujIgumane.service.rentacar.RentACarServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;

@RestController
@RequestMapping(value="api/rentacar", produces="application/json;charset=UTF-8")
public class RentACarController {
	@Autowired
	private RentACarService rentacarServiceImpl;
	
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
	
	@RequestMapping(value="/editRentacar", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> updateRentacar(@RequestBody RentACarDTO rentacar){
		
		RentACar updatedRentacar = null;
		
		try {
			updatedRentacar = rentacarServiceImpl.update(rentacar);
		} catch (Exception e) {
			return new ResponseEntity<RentACar>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<RentACar>(updatedRentacar, HttpStatus.OK);
	}
	
	@RequestMapping(value="/spisakFilijala/{rentacarId}", method=RequestMethod.GET)
	public ResponseEntity<?> getSpisakFilijala(@PathVariable("rentacarId")Long rentacarId){
		
		HashSet<Filijala> f = rentacarServiceImpl.getSpisakFilijala(rentacarId);
		
		List<FilijalaDTO> fDTO = ObjectMapperUtils.mapAll(f, FilijalaDTO.class);
		
		return new ResponseEntity<>(fDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addFilijala/{rentacarId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> addFilijala(@PathVariable("rentacarId")Long rentacarId,@RequestBody FilijalaDTO f){
		
		Filijala addedf = null;
		
		try {
			addedf = rentacarServiceImpl.addFilijala(f,rentacarId);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		FilijalaDTO fDTO=ObjectMapperUtils.map(addedf, FilijalaDTO.class);
		
		return new ResponseEntity<>(fDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editFilijala/{filijalaId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> getFilijala(@PathVariable("filijalaId")Long id){
		
		Filijala f = rentacarServiceImpl.getFilijala(id);
		
		if(f == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		FilijalaDTO fDTO=ObjectMapperUtils.map(f, FilijalaDTO.class);
		
		return new ResponseEntity<>(fDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateFilijala", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> updateFilijala(@RequestBody FilijalaDTO f){
		
		Filijala updatedf = null;
		
		try {
			updatedf = rentacarServiceImpl.updateFilijala(f);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<>(updatedf, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/filijala", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> deleteFilijala(@RequestParam("id") Long id,@RequestParam("rentacarId") Long rentacarId) {
		
		HashSet<Filijala> f = rentacarServiceImpl.deleteFilijala(id,rentacarId);
		
		List<FilijalaDTO> fDTO = ObjectMapperUtils.mapAll(f, FilijalaDTO.class);
		
		return new ResponseEntity<>(fDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/vozila/{rentacarId}", method=RequestMethod.GET)
	public ResponseEntity<?> getVozila(@PathVariable("rentacarId")Long rentacarId){
		
		HashSet<Vozilo> vozila = rentacarServiceImpl.getNerezervisanaVozila(rentacarId);
		List<Vozilo> rezVozila = rentacarServiceImpl.getRezervisanaVozila(rentacarId);
		
		List<VoziloDTO> vozilaDTO = ObjectMapperUtils.mapAll(vozila, VoziloDTO.class);
		List<VoziloDTO> rezVozilaDTO = ObjectMapperUtils.mapAll(rezVozila, VoziloDTO.class);
		
		List<List<VoziloDTO>> svaVozila = new ArrayList<>();
		svaVozila.add(vozilaDTO);
		svaVozila.add(rezVozilaDTO);
		
		return new ResponseEntity<>(svaVozila, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editVozilo/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> getVozilo(@PathVariable("id")Long id){
		
		Vozilo vozilo = rentacarServiceImpl.getVozilo(id);
		
		if(vozilo == null){			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
				
		VoziloDTO voziloDTO=ObjectMapperUtils.map(vozilo, VoziloDTO.class);
		
		return new ResponseEntity<>(voziloDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateVozilo", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> updateVozilo(@RequestBody VoziloDTO vozilo){
		
		Vozilo updatedVozilo = null;
		
		try {
			updatedVozilo = rentacarServiceImpl.updateVozilo(vozilo);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		return new ResponseEntity<>(updatedVozilo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addVozilo/{rentacarId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> addVozilo(@PathVariable("rentacarId")Long rentacarId,@RequestBody VoziloDTO vozilo){
		
		Vozilo addedVozilo = null;
		
		addedVozilo = rentacarServiceImpl.addVozilo(vozilo,rentacarId);
		
		VoziloDTO voziloDTO=ObjectMapperUtils.map(addedVozilo, VoziloDTO.class);
		
		return new ResponseEntity<>(voziloDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/vozilo", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> deleteVozilo(@RequestParam("id") Long id,@RequestParam("rentacarId") Long rentacarId) {
		
		HashSet<Vozilo> vozilo = rentacarServiceImpl.deleteVozilo(id,rentacarId);
		
		List<VoziloDTO> voziloDTO = ObjectMapperUtils.mapAll(vozilo, VoziloDTO.class);
		
		return new ResponseEntity<>(voziloDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/rentacar/{rentacarId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> getOceneRentacar(@PathVariable("rentacarId")Long rentacarId){
		
		RentACar h = new RentACar();
		h.setId(rentacarId);
		
		List<Ocena> ocene = rentacarServiceImpl.getOceneRentacar(h);
		
		List<OcenaRentacarDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaRentacarDTO ocenaDTO = new OcenaRentacarDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ocene/vozilo/{voziloId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> getOceneVozila(@PathVariable("voziloId")Long voziloId){
		
		Vozilo v = new Vozilo();
		v.setId(voziloId);
		
		List<Ocena> ocene = rentacarServiceImpl.getOceneVozila(v);
		
		List<OcenaRentacarDTO> oceneDTO = new ArrayList<>();
		
		for (Ocena ocena : ocene) {
			OcenaRentacarDTO ocenaDTO = new OcenaRentacarDTO(ocena.getKorisnik().getUsername(),ocena.getVrednost());
			oceneDTO.add(ocenaDTO);
		}
		
		return new ResponseEntity<>(oceneDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/prihodi/{rentacarId}", method=RequestMethod.GET)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> getPrihode(@PathVariable("rentacarId")Long rentacarId,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate){
		
		Double prihodi = rentacarServiceImpl.getPrihode(rentacarId,fromDate,toDate);
		
		if(prihodi==null)
			prihodi = new Double(0);
		
		return new ResponseEntity<>(prihodi, HttpStatus.OK);
	}
	
	@RequestMapping(value="/setStatusi/{voziloId}", method=RequestMethod.PUT)
	@PreAuthorize("hasRole('RADMIN')")
	public ResponseEntity<?> setStatuse(@PathVariable("voziloId")Long voziloId, @RequestParam("cena") Double cena,@RequestParam("popust") Short popust,@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to){
			
		List<StatusVozila> statusiVozila=rentacarServiceImpl.setStatuse(voziloId,cena,popust,from,to);
		
		List<StatusVozilaDTO> svDTO = ObjectMapperUtils.mapAll(statusiVozila, StatusVozilaDTO.class);
		
		return new ResponseEntity<>(svDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/vozilo/rez", method=RequestMethod.GET)
	public ResponseEntity<?> getVoziloZaRez(@RequestParam("cenaFrom") Double cenaFrom,@RequestParam("cenaTo") Double cenaTo,@RequestParam("datumFrom") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate datumFrom,@RequestParam("datumTo") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate datumTo,@RequestParam("brojSedista") int brojSedista){
		List<VoziloZaRezDTO> vozilaDTO=ObjectMapperUtils.mapAll(rentacarServiceImpl.getVoziloZaRez(cenaFrom, cenaTo, datumFrom, datumTo, brojSedista), VoziloZaRezDTO.class);
	
		
		for (VoziloZaRezDTO v : vozilaDTO) {
			v.setCena(rentacarServiceImpl.getUkupnaCena(v.getId(),datumFrom,datumTo));
		}
		
		for (VoziloZaRezDTO voziloDTO : vozilaDTO) {
			System.out.println(voziloDTO.getId());
		}
		
		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/add/rent", method=RequestMethod.PUT)
	public ResponseEntity<?> addRent(@RequestBody RentACarDTO rent){
		
		RentACar addedRent = null;
		
		try {
			addedRent = rentacarServiceImpl.addRent(rent);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
		}
		
		RentACarDTO rentDTO=ObjectMapperUtils.map(addedRent, RentACarDTO.class);
		
		return new ResponseEntity<>(rentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/null/r", method = RequestMethod.GET)
	public ResponseEntity<?> getAllRentNull() {
		
		List<RentACarDTO> rentDTO=ObjectMapperUtils.mapAll(rentacarServiceImpl.getAllNull(), RentACarDTO.class);
		
		return new ResponseEntity<>(rentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/vozilo/brza", method=RequestMethod.GET)
	public ResponseEntity<?> getVozilaBrza(@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate from,@RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate to){

		List<VozilaBrzaDTO> vozilaDTO = rentacarServiceImpl.getVozilaBrza(from,to);		

		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK); 
	}
	
}

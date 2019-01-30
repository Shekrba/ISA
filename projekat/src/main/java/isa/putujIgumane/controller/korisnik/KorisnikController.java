package isa.putujIgumane.controller.korisnik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import isa.putujIgumane.dto.aviokompanija.AKAdminDTO;
import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.korisnik.KorisnikDTO;
import isa.putujIgumane.dto.korisnik.ZahtevDTO;
import isa.putujIgumane.model.korisnik.Authority;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Zahtev;
import isa.putujIgumane.service.korisnik.KorisnikServiceImpl;
import isa.putujIgumane.utils.ObjectMapperUtils;

@RestController
@RequestMapping(value = "/api/korisnik", produces = MediaType.APPLICATION_JSON_VALUE)
public class KorisnikController{

	@Autowired
	private KorisnikServiceImpl korisnikService;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getKorisnikLike(@RequestParam("name") String name,@RequestParam("page") int page){
		String loggedUser=SecurityContextHolder.getContext().getAuthentication().getName();
		name=name.replace('+', ' ');
		Page<Korisnik> korisnici=korisnikService.getKorisnikLike(new PageRequest(page-1,10),name,loggedUser);
		List<KorisnikDTO> korisniciDTO=ObjectMapperUtils.mapAll(korisnici.getContent(), KorisnikDTO.class);
		return new ResponseEntity<List<KorisnikDTO>>(korisniciDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="/friend/{id}", method=RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> addFriend(@PathVariable("id") Long id){
		String loggedUser=SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			korisnikService.sendFriendRequest(loggedUser, id);
		}catch(Exception e) {
			return new ResponseEntity<String>("Greska pri slanju zahteva!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Zahtev je uspešno poslat!",HttpStatus.OK);
	}
	
	@RequestMapping(value="/friendship", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getFriendsAndRequests(){
		String loggedUser=SecurityContextHolder.getContext().getAuthentication().getName();
		List<Long> potentialFriends=korisnikService.getFriendsAndRequests(loggedUser);
		return new ResponseEntity<List<Long>>(potentialFriends,HttpStatus.OK);
	}
	
	@RequestMapping(value="/requests", method=RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getFriendRequests(){
		String loggedUser=SecurityContextHolder.getContext().getAuthentication().getName();
		List<Zahtev> potentialFriends=korisnikService.getFriendsRequests(loggedUser);
		List<ZahtevDTO> zahtevi=ObjectMapperUtils.mapAll(potentialFriends, ZahtevDTO.class);
		return new ResponseEntity<List<ZahtevDTO>>(zahtevi,HttpStatus.OK);
	}
	
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public ResponseEntity<?> getUserData() {
		Korisnik k=korisnikService.getKorisnik(SecurityContextHolder.getContext().getAuthentication().getName());
		Authority a=((List<Authority>)k.getAuthorities()).get(0);
		switch(a.getName()) {
		case "ROLE_USER":{
			KorisnikDTO kDTO=ObjectMapperUtils.map(k, KorisnikDTO.class);
			return new ResponseEntity<KorisnikDTO>(kDTO,HttpStatus.OK);
		}
		case "ROLE_ADMIN":{
			
		}break;
		case "ROLE_AKADMIN":{
			AKAdminDTO akaDTO=ObjectMapperUtils.map(k, AKAdminDTO.class);
			return new ResponseEntity<AKAdminDTO>(akaDTO,HttpStatus.OK);
		}
		}
		return new ResponseEntity<String>("Error",HttpStatus.OK);
	}
	
}

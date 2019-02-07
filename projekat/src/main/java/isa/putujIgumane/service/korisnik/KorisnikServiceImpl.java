package isa.putujIgumane.service.korisnik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.korisnik.AdminHotelaDTO;
import isa.putujIgumane.dto.korisnik.KorisnikDTO;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.StatusZahteva;
import isa.putujIgumane.model.korisnik.Zahtev;
import isa.putujIgumane.repository.hotel.HotelRepository;
import isa.putujIgumane.repository.korisnik.KorisnikRepository;
import isa.putujIgumane.repository.korisnik.ZahtevRepository;

@Service
public class KorisnikServiceImpl implements KorisnikService{

	@Autowired 
	KorisnikRepository korisnikRepo;
	
	@Autowired 
	ZahtevRepository zahtevRepo;
	
	@Autowired
	HotelRepository hotelRepo;
	
	@Override
	public Korisnik getKorisnik(Long id) {
		return korisnikRepo.findById(id);
	}

	@Override
	public Page<Korisnik> getKorisnikLike(Pageable pageable, String s,String loggedUser) {
		return korisnikRepo.searchByFullName(s, loggedUser,pageable );
	}

	@Override
	public void sendFriendRequest(String username, Long friend) throws Exception{
		Korisnik k1=korisnikRepo.findByUsername(username);
		Korisnik k2=korisnikRepo.findById(friend);
		
		Zahtev z=new Zahtev();
		z.setSalje(k1);
		z.setPrima(k2);
		z.setStatus(StatusZahteva.POSLAT);
		
		zahtevRepo.save(z);
	}

	@Override
	public List<Long> getFriendsAndRequests(String username) {
		List<Long> sent = zahtevRepo.findFriendsAndSentRequests(username);
		List<Long> rec= zahtevRepo.findFriendsAndRecievedRequests(username);
		sent.addAll(rec);
		return sent;
	}

	@Override
	public void answerRequest(Long id,boolean flag) {
		Zahtev z=zahtevRepo.findOne(id);
		if(flag) {
			z.setStatus(StatusZahteva.PRIHVACEN);
		}else {
			z.setStatus(StatusZahteva.ODBIJEN);
		}
		zahtevRepo.save(z);
	}

	@Override
	public List<Zahtev> getFriendsRequests(String username) {
		return zahtevRepo.findRequestsOfUser(username);
	}

	@Override
	public Korisnik getKorisnik(String username) {
		return korisnikRepo.findByUsername(username);
	}

	@Override
	public Korisnik addKorisnik(KorisnikDTO korisnik) {
		Korisnik korisnikToAdd = new Korisnik();

		korisnikToAdd.setUsername(korisnik.getUsername());
		korisnikToAdd.setPassword("123");
		korisnikToAdd.setIme(korisnik.getIme());
		korisnikToAdd.setPrezime(korisnik.getPrezime());
		korisnikToAdd.setEmail(korisnik.getEmail());
		korisnikToAdd.setEnabled(true);
						
		korisnikRepo.save(korisnikToAdd);
        
        return korisnikToAdd;
	}

	@Override
	public Korisnik addAdminHotel(AdminHotelaDTO admin) {
		Korisnik adminNew = new Korisnik();
		
		adminNew.setUsername(admin.getUsername());
		adminNew.setPassword(admin.getPassword());
		adminNew.setIme(admin.getIme());
		adminNew.setPrezime(admin.getPrezime());
		adminNew.setEmail(admin.getEmail());
		adminNew.setVerifikovan(true);
		adminNew.setEnabled(true);
		
		Hotel hotel = hotelRepo.findOneByNaziv(admin.getHotelNaz());
		
		adminNew.setHotel(hotel);
		
        korisnikRepo.save(adminNew);
        
        hotel.setAdmin(adminNew);
        hotelRepo.save(hotel);
        
        return adminNew;
	}

}

package isa.putujIgumane.service.korisnik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OptimisticLockException;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.RezervacijaSobeDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.StatusSobeDTO;
import isa.putujIgumane.dto.korisnik.AdminAvioDTO;
import isa.putujIgumane.dto.korisnik.AdminHotelaDTO;
import isa.putujIgumane.dto.korisnik.AdminRentDTO;
import isa.putujIgumane.dto.korisnik.KorisnikDTO;
import isa.putujIgumane.dto.korisnik.RezervacijaDTO;
import isa.putujIgumane.dto.rentacar.RezervacijaVozilaDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.RezervacijaSobe;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Rezervacija;
import isa.putujIgumane.model.korisnik.StatusZahteva;
import isa.putujIgumane.model.korisnik.Zahtev;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.RezervacijaVozila;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.repository.aviokompanija.AvioKompanijaRepository;
import isa.putujIgumane.repository.hotel.HotelRepository;
import isa.putujIgumane.repository.hotel.SobaRepository;
import isa.putujIgumane.repository.hotel.StatusSobeRepository;
import isa.putujIgumane.repository.korisnik.KorisnikRepository;
import isa.putujIgumane.repository.korisnik.RezervacijaRepository;
import isa.putujIgumane.repository.korisnik.ZahtevRepository;
import isa.putujIgumane.repository.rentacar.RentACarRepository;
import isa.putujIgumane.repository.rentacar.StatusVozilaRepository;
import isa.putujIgumane.repository.rentacar.VoziloRepository;
import isa.putujIgumane.utils.ObjectMapperUtils;

@Transactional(readOnly = true)
@Service
public class KorisnikServiceImpl implements KorisnikService{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	KorisnikRepository korisnikRepo;
	
	@Autowired 
	ZahtevRepository zahtevRepo;
	
	@Autowired
	HotelRepository hotelRepo;
	
	@Autowired
	AvioKompanijaRepository avioRepo;
	
	@Autowired
	RentACarRepository rentRepo;
	
	@Autowired
	RezervacijaRepository rezRepo;
	
	@Autowired
	StatusSobeRepository statusSobeRepo;
	
	@Autowired
	SobaRepository sobaRepo;
	
	@Autowired
	StatusVozilaRepository statusVozilaRepo;
	
	@Autowired
	VoziloRepository voziloRepo;
	
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
		korisnikToAdd.setPassword(passwordEncoder.encode(korisnik.getPassword()));
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
		adminNew.setPassword(passwordEncoder.encode(admin.getPassword()));
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
	
	@Override
	public Korisnik addAdminAvio(AdminAvioDTO admin) {
		Korisnik adminNew = new Korisnik();
		
		adminNew.setUsername(admin.getUsername());
		adminNew.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminNew.setIme(admin.getIme());
		adminNew.setPrezime(admin.getPrezime());
		adminNew.setEmail(admin.getEmail());
		adminNew.setVerifikovan(true);
		adminNew.setEnabled(true);
		
		AvioKompanija avio = avioRepo.findOneByNaziv(admin.getAvioNaz());
		
		adminNew.setAvioKompanija(avio);
		
        korisnikRepo.save(adminNew);
        
        avio.setAdmin(adminNew);
        avioRepo.save(avio);
        
        return adminNew;
	}

	@Override
	public Korisnik addAdminRent(AdminRentDTO admin) {
		Korisnik adminNew = new Korisnik();
		
		adminNew.setUsername(admin.getUsername());
		adminNew.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminNew.setIme(admin.getIme());
		adminNew.setPrezime(admin.getPrezime());
		adminNew.setEmail(admin.getEmail());
		adminNew.setVerifikovan(true);
		adminNew.setEnabled(true);
		
		RentACar rent = rentRepo.findOneByNazivServisa(admin.getRentNaz());
		
		adminNew.setRentACar(rent);
		
        korisnikRepo.save(adminNew);
        
        rent.setAdmin(adminNew);
        rentRepo.save(rent);
        
        return adminNew;
	}
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Rezervacija makeRez(RezervacijaDTO rez,Korisnik k) throws Exception {
		Rezervacija rezNew = new Rezervacija();
		
		rezNew.setKorisnik(k);
		
		for (RezervacijaSobeDTO rs : rez.getRezervacijaSobe()) {
			SobaDTO sDTO=rs.getSoba();
			RezervacijaSobe rsNew = new RezervacijaSobe();
			rsNew.setDatum(LocalDate.now());
			rsNew.setDatumDolaska(rs.getDatumDolaska());
			rsNew.setDatumOdlaska(rs.getDatumOdlaska());
			rsNew.setOtkazano(false);
			
			Soba soba = sobaRepo.findOneById(rs.getSoba().getId());
			
			for (StatusSobeDTO ssDTO :sDTO.getStatusSobe()) {
				if(ssDTO.getDatum().isEqual(rsNew.getDatumDolaska()) || (ssDTO.getDatum().isAfter(rsNew.getDatumDolaska()) && ssDTO.getDatum().isBefore(rsNew.getDatumOdlaska()))) {
					StatusSobe ssNew = statusSobeRepo.findOne(ssDTO.getId());
					
					ssNew.setZauzeto(true);
					
					if(ssNew.getVersion()!=ssDTO.getVersion()) {
						throw new OptimisticLockException();
					}
					
					soba.getStatusSobe().add(ssNew);
					
					//System.out.println(ss.getVersion());
				}
			}
			
			rsNew.setSoba(soba);
			soba.getRezervacije().add(rsNew);
			rsNew.setUkupnaCena(statusSobeRepo.findUkupnaCena(soba.getId(),rsNew.getDatumDolaska(),rsNew.getDatumOdlaska()));
			rsNew.setRezervacija(rezNew);
			
			rezNew.getRezervacijaSobe().add(rsNew);
			
			
		}
		
		for (RezervacijaVozilaDTO rv : rez.getRezervacijaVozila()) {
			RezervacijaVozila rvNew = new RezervacijaVozila();
			rvNew.setDatum(LocalDate.now());
			rvNew.setDatumDolaska(rv.getDatumDolaska());
			rvNew.setDatumOdlaska(rv.getDatumOdlaska());
			rvNew.setOtkazano(false);
			
			Vozilo vozilo = voziloRepo.findOneById(rv.getVozilo().getId());
		
			for (StatusVozila sv : vozilo.getStatusVozila()) {
				if(sv.getDatum().isEqual(rvNew.getDatumDolaska()) || (sv.getDatum().isAfter(rvNew.getDatumDolaska()) && sv.getDatum().isBefore(rvNew.getDatumOdlaska())) || sv.getDatum().isEqual(rvNew.getDatumOdlaska())) {
					sv.setVoziloJeIznajmljeno(true);
				}
			}
			
			rvNew.setVozilo(vozilo);
			vozilo.getRezervacije().add(rvNew);
			rvNew.setUkupnaCena(statusVozilaRepo.findUkupnaCena(vozilo.getId(),rvNew.getDatumDolaska(),rvNew.getDatumOdlaska()));
			rvNew.setRezervacija(rezNew);
			
			rezNew.getRezervacijaVozila().add(rvNew);
			
			
		}
		
        
		k.getRezervacije().add(rezNew);
		
        return rezRepo.save(rezNew);
	}
	
}

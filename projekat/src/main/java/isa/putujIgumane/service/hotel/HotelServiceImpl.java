package isa.putujIgumane.service.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.border.SoftBevelBorder;

import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.SobeBrzaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.repository.hotel.CenovnikUslugaHotelaRepository;
import isa.putujIgumane.repository.hotel.HotelRepository;
import isa.putujIgumane.repository.hotel.SobaRepository;
import isa.putujIgumane.repository.hotel.StatusSobeRepository;
import isa.putujIgumane.repository.korisnik.OcenaRepository;

@Service
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private CenovnikUslugaHotelaRepository cenovnikUslugaHotelaRepository;
	@Autowired
	private SobaRepository sobaRepository;
	@Autowired
	private StatusSobeRepository statusSobeReposatory;
	@Autowired
	private OcenaRepository ocenaRepository;
	
	@Override
	public List<Hotel> getAll() {
		
		List<Hotel> hoteli = hotelRepository.findAll();
		
		return hoteli;
	}
	
	@Override
	public List<Hotel> getAllNull() {
		
		List<Hotel> hoteli = hotelRepository.findAll();
		
		List<Hotel> hoteliNull = new ArrayList<>();
		
		for (Hotel hotel : hoteli) {
			if(hotel.getAdmin()==null) {
				hoteliNull.add(hotel);
			}
		}
		
		return hoteliNull;
	}
	
	@Override
	public Hotel findById(Long id) {
		Hotel hotel = hotelRepository.findOneById(id);
		hotel.setCenovnikUsluga(cenovnikUslugaHotelaRepository.findByHotel(hotel));
		hotel.setSobe(sobaRepository.findByHotel(hotel));
		return hotel;
	}
	
	@Override
	public HashSet<Soba> getSveSobe(Hotel hotel) {
		return sobaRepository.findByHotel(hotel);
	}
	
	@Override
	public HashSet<StatusSobe> findStatusBySoba(Soba soba) {
		return statusSobeReposatory.findBySoba(soba);
	}
	
	@Override
	public List<Soba> getFreeSoba(Long hotelId, LocalDate from, LocalDate to){
		
		Long days = ChronoUnit.DAYS.between(from, to) + 1;
		
		return sobaRepository.findFreeSobe(hotelId, from, to,days);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Hotel update(HotelDTO hotel) throws Exception {
		
        Hotel hotelToUpdate = new Hotel();//findById(hotel.getId());
        hotelToUpdate.setNaziv(hotel.getNaziv());
        hotelToUpdate.setAdresa(hotel.getAdresa());
        hotelToUpdate.setOpis(hotel.getOpis());
        hotelToUpdate.setProsecnaOcena(hotel.getProsecnaOcena());
        hotelToUpdate.setId(hotel.getId());
        hotelRepository.save(hotelToUpdate);
      
        return hotelToUpdate;
    }
	
	@Override
	public HashSet<CenovnikUslugaHotela> getCenovnik(Long hotelId){
		Hotel hotel = hotelRepository.findOneById(hotelId);
		
		return cenovnikUslugaHotelaRepository.findByHotel(hotel);
	}
	
	@Override
	public CenovnikUslugaHotela getUsluga(Long id) {
		return cenovnikUslugaHotelaRepository.findOneById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public CenovnikUslugaHotela updateCenovnik(CenovnikUslugaHotelaDTO cenovnik) {
		CenovnikUslugaHotela cenovnikToUpdate = new CenovnikUslugaHotela();
		cenovnikToUpdate.setId(cenovnik.getId());
		cenovnikToUpdate.setCena(cenovnik.getCena());
		cenovnikToUpdate.setUsluga(cenovnik.getUsluga());
		cenovnikToUpdate.setVersion(cenovnik.getVersion());
	
		Hotel hotel = getUsluga(cenovnik.getId()).getHotel();
		
		cenovnikToUpdate.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),new HashSet<Soba>(),new HashSet<CenovnikUslugaHotela>(),hotel.getProsecnaOcena()));

        cenovnikUslugaHotelaRepository.save(cenovnikToUpdate);
      
        return cenovnikToUpdate;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public HashSet<CenovnikUslugaHotela> deleteCenovnik(Long id,Long hotelId) {
		
		cenovnikUslugaHotelaRepository.delete(getUsluga(id));
		
		return getCenovnik(hotelId);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public CenovnikUslugaHotela addCenovnik(CenovnikUslugaHotelaDTO cenovnik,Long hotelId) {
		CenovnikUslugaHotela cenovnikNew = new CenovnikUslugaHotela();
		cenovnikNew.setCena(cenovnik.getCena());
		cenovnikNew.setUsluga(cenovnik.getUsluga());
	
		Hotel hotel = hotelRepository.findOneById(hotelId);
	
		cenovnikNew.setHotel(hotel);
		
        cenovnikUslugaHotelaRepository.save(cenovnikNew);
      
        
        
        return cenovnikNew;
	}
	
	@Override
	public HashSet<Soba> getNerezervisaneSobe(Long hotelId){
		Hotel hotel = findById(hotelId);
		
		HashSet<Soba> sobe = sobaRepository.findByHotel(hotel);
		
		for (Soba soba : sobaRepository.findRezSobe(hotelId, LocalDate.now())) {
			sobe.remove(soba);
		}
		
		return sobe;
	}
	
	@Override
	public List<Soba> getRezervisaneSobe(Long hotelId){
		LocalDate today = LocalDate.now();
		return sobaRepository.findRezSobe(hotelId, today);
	}

	@Override
	public Soba getSoba(Long id) {
		return sobaRepository.findOneById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Soba updateSoba(SobaDTO soba) {
		Soba sobaToUpdate = new Soba();
		sobaToUpdate.setId(soba.getId());
		sobaToUpdate.setBrojSobe(soba.getBrojSobe());
		sobaToUpdate.setSprat(soba.getSprat());
		sobaToUpdate.setBrojKreveta(soba.getBrojKreveta());
		sobaToUpdate.setVersion(soba.getVersion());
	
		Hotel hotel = getSoba(soba.getId()).getHotel();
		
		sobaToUpdate.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),new HashSet<Soba>(),new HashSet<CenovnikUslugaHotela>(),hotel.getProsecnaOcena()));

        sobaRepository.save(sobaToUpdate);
      
        return sobaToUpdate;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Soba addSoba(SobaDTO soba,Long hotelId) {
		Soba sobaNew = new Soba();

		sobaNew.setBrojSobe(soba.getBrojSobe());
		sobaNew.setSprat(soba.getSprat());
		sobaNew.setBrojKreveta(soba.getBrojKreveta());
		
		Hotel hotel = hotelRepository.findOneById(hotelId);
		
		sobaNew.setHotel(hotel);
		
        sobaRepository.save(sobaNew);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse("2019-01-01", formatter);
        
        for(int i = 0; i < 365; i++) {
        	StatusSobe ss = new StatusSobe();
        	ss.setSoba(sobaNew);
        	ss.setDatum(datum);
        	ss.setZauzeto(false);
        	ss.setCena(2000);
        	ss.setPopust((short)0);
        	statusSobeReposatory.save(ss);
        	
        	datum = datum.plusDays(1);
        }
        
        return sobaNew;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public HashSet<Soba> deleteSoba(Long id,Long hotelId) {
		
		sobaRepository.delete(getSoba(id));
		
		return getNerezervisaneSobe(hotelId);
	}
	
	@Override
	public List<Ocena> getOceneHotela(Hotel hotel){
		return ocenaRepository.findByHotel(hotel);
	}
	
	@Override
	public List<Ocena> getOceneSobe(Soba soba){
		return ocenaRepository.findBySoba(soba);
	}
	
	@Override
	public Double getPrihode(Long hotelId, LocalDate from, LocalDate to) {
		return sobaRepository.findPrihodeHotela(hotelId, from, to);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<StatusSobe> setStatuse(Long sobaId,Double cena, Short popust, LocalDate from, LocalDate to){
		
		List<StatusSobe> statusiSobe = statusSobeReposatory.findInDateBySoba(sobaId,from,to);
		
		for (StatusSobe ss : statusiSobe) {
			ss.setCena(cena);
			ss.setPopust(popust);
			
			statusSobeReposatory.save(ss);
		}
		
		return statusiSobe;
	}
	
	@Override
	public List<Soba> getSobeZaRez(Long hotelId,Double cenaFrom,Double cenaTo,LocalDate datumFrom, LocalDate datumTo, boolean jed, boolean dvo, boolean tro, boolean cet){
		
		Long days = ChronoUnit.DAYS.between(datumFrom, datumTo) + 1;
		
		List<Soba> sobe = sobaRepository.findSobeZaRez(cenaFrom, cenaTo, datumFrom, datumTo, days,hotelId);
		
		List<Soba> filtSobe = new ArrayList<>();
		
		if(sobe == null)
			return null;
		
		for (Soba s : sobe) {
			if(jed==true && s.getBrojKreveta()==1) {
				filtSobe.add(s);
				continue;
			}
			if(dvo==true && s.getBrojKreveta()==2) {
				filtSobe.add(s);
				continue;
			}
			if(tro==true && s.getBrojKreveta()==3) {
				filtSobe.add(s);
				continue;
			}
			if(cet==true && s.getBrojKreveta()==4) {
				filtSobe.add(s);
				continue;
			}
		}
		
		return filtSobe;
	}
	
	@Override
	public List<SobeBrzaDTO> getSobeBrza(Long hotelId,LocalDate from, LocalDate to){
		
		Long days = ChronoUnit.DAYS.between(from, to) + 1;
		
		List<Soba> sobe = sobaRepository.findSobeBrza(hotelId,from,to,days);
		
		List<SobeBrzaDTO> sobeDTO = new ArrayList<>();
		
		for (Soba s : sobe) {
			SobeBrzaDTO sDTO = new SobeBrzaDTO();
			sDTO.setBrojSobe(s.getBrojSobe());
			sDTO.setBrojKreveta(s.getBrojKreveta());
			sDTO.setSprat(s.getSprat());
			sDTO.setId(s.getId());
			sDTO.setPopust(statusSobeReposatory.findPopust(s.getId(), from));
			sDTO.setCena(statusSobeReposatory.findUkupnaCena(s.getId(), from, to));
			
			sobeDTO.add(sDTO);
		}
		
		
		
		return sobeDTO;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Hotel addHotel(HotelDTO hotel) {
		Hotel hotelNew = new Hotel();

		hotelNew.setNaziv(hotel.getNaziv());
		hotelNew.setAdresa(hotel.getAdresa());
		hotelNew.setOpis(hotel.getOpis());
		hotelNew.setProsecnaOcena(0.0);
		
        hotelRepository.save(hotelNew);
        
        return hotelNew;
	}
	
	@Override
	public double getUkupnaCena(Long sobaId, LocalDate from, LocalDate to) {
		return statusSobeReposatory.findUkupnaCena(sobaId, from, to);
	}
}

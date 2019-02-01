package isa.putujIgumane.service.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
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
		Hotel hotel = findById(hotelId);
		
		return cenovnikUslugaHotelaRepository.findByHotel(hotel);
	}
	
	@Override
	public CenovnikUslugaHotela getUsluga(Long id) {
		return cenovnikUslugaHotelaRepository.findOneById(id);
	}
	
	@Override
	public CenovnikUslugaHotela updateCenovnik(CenovnikUslugaHotelaDTO cenovnik) {
		CenovnikUslugaHotela cenovnikToUpdate = new CenovnikUslugaHotela();
		cenovnikToUpdate.setId(cenovnik.getId());
		cenovnikToUpdate.setCena(cenovnik.getCena());
		cenovnikToUpdate.setUsluga(cenovnik.getUsluga());
	
		Hotel hotel = getUsluga(cenovnik.getId()).getHotel();
		
		cenovnikToUpdate.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),new HashSet<Soba>(),new HashSet<CenovnikUslugaHotela>(),hotel.getProsecnaOcena()));

        cenovnikUslugaHotelaRepository.save(cenovnikToUpdate);
      
        return cenovnikToUpdate;
	}
	
	@Override
	public HashSet<CenovnikUslugaHotela> deleteCenovnik(Long id,Long hotelId) {
		
		cenovnikUslugaHotelaRepository.delete(getUsluga(id));
		
		return getCenovnik(hotelId);
	}
	
	@Override
	public CenovnikUslugaHotela addCenovnik(CenovnikUslugaHotelaDTO cenovnik,Long hotelId) {
		CenovnikUslugaHotela cenovnikNew = new CenovnikUslugaHotela();
		cenovnikNew.setCena(cenovnik.getCena());
		cenovnikNew.setUsluga(cenovnik.getUsluga());
	
		Hotel hotel = findById(hotelId);
		
		//cenovnikNew.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),hotel.getSobe(),hotel.getCenovnikUsluga(),hotel.getProsecnaOcena()));
		
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

	@Override
	public Soba updateSoba(SobaDTO soba) {
		Soba sobaToUpdate = new Soba();
		sobaToUpdate.setId(soba.getId());
		sobaToUpdate.setBrojSobe(soba.getBrojSobe());
		sobaToUpdate.setSprat(soba.getSprat());
		sobaToUpdate.setBrojKreveta(soba.getBrojKreveta());
	
		Hotel hotel = getSoba(soba.getId()).getHotel();
		
		sobaToUpdate.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),new HashSet<Soba>(),new HashSet<CenovnikUslugaHotela>(),hotel.getProsecnaOcena()));

        sobaRepository.save(sobaToUpdate);
      
        return sobaToUpdate;
	}
	
	@Override
	public Soba addSoba(SobaDTO soba,Long hotelId) {
		Soba sobaNew = new Soba();

		sobaNew.setBrojSobe(soba.getBrojSobe());
		sobaNew.setSprat(soba.getSprat());
		sobaNew.setBrojKreveta(soba.getBrojKreveta());
	
		Hotel hotel = findById(hotelId);
		
		//cenovnikNew.setHotel(new Hotel(hotel.getId(),hotel.getNaziv(),hotel.getAdresa(),hotel.getOpis(),hotel.getSobe(),hotel.getCenovnikUsluga(),hotel.getProsecnaOcena()));
		
		sobaNew.setHotel(hotel);
		
        sobaRepository.save(sobaNew);
      
        return sobaNew;
	}
	
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
}

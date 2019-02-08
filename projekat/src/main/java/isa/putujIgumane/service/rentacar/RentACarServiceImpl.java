package isa.putujIgumane.service.rentacar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import isa.putujIgumane.dto.aviokompanija.AvioKompanijaDTO;
import isa.putujIgumane.dto.korisnik.RezervacijaDTO;
import isa.putujIgumane.dto.rentacar.FilijalaDTO;
import isa.putujIgumane.dto.rentacar.RentACarDTO;
import isa.putujIgumane.dto.rentacar.VozilaBrzaDTO;
import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.model.korisnik.Rezervacija;
import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;
import isa.putujIgumane.repository.korisnik.KorisnikRepository;
import isa.putujIgumane.repository.korisnik.OcenaRepository;
import isa.putujIgumane.repository.korisnik.RezervacijaRepository;
import isa.putujIgumane.repository.rentacar.FilijalaRepository;
import isa.putujIgumane.repository.rentacar.RentACarRepository;
import isa.putujIgumane.repository.rentacar.StatusVozilaRepository;
import isa.putujIgumane.repository.rentacar.VoziloRepository;

@Service
@Transactional(readOnly = true)
public class RentACarServiceImpl implements RentACarService{

	@Autowired
	private RentACarRepository rentACarRepository;
	
	@Autowired
	private FilijalaRepository filijalaRepository;
	
	@Autowired
	private VoziloRepository voziloRepository;
	
	@Autowired
	private StatusVozilaRepository statusVozilaRepository;
	
	@Autowired
	private OcenaRepository ocenaRepository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Override
	public List<RentACar> getAll() {

		List<RentACar> rentacari = rentACarRepository.findAll();
		return rentacari;
	}

	@Override
	public RentACar findById(Long id) {
		RentACar rentACar = rentACarRepository.findOneById(id);
		rentACar.setFilijale(filijalaRepository.findByRentACar(rentACar));
		for (Filijala f : rentACar.getFilijale()) {
			f.setRentACar(rentACar);
		}
		rentACar.setListaVozila(voziloRepository.findByRentACar(rentACar));
		for (Vozilo v : rentACar.getListaVozila()) {
			v.setRentACar(rentACar);
		}
		return rentACar;
	}

	@Override
	public HashSet<Vozilo> findVoziloByRentACar(RentACar rentacar) {

		return voziloRepository.findByRentACar(rentacar);
	}

	@Override
	public HashSet<StatusVozila> findStatusByVozilo(Vozilo vozilo) {
		
		return statusVozilaRepository.findByVozilo(vozilo);
	}

	@Override
	public List<Vozilo> getFreeVozilo(Long rentacarId, LocalDate from, LocalDate to) {
		
		Long days = ChronoUnit.DAYS.between(from, to) + 1;
		
		return voziloRepository.findFreeVozila(rentacarId, from, to, days);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public RentACar update(RentACarDTO rentacar) throws Exception {
		
		RentACar r = new RentACar();
		r.setId(rentacar.getId());
		r.setNazivServisa(rentacar.getNazivServisa());
		r.setAdresaServisa(rentacar.getAdresaServisa());
		r.setOpisServisa(rentacar.getOpisServisa());
		r.setProsecnaOcenaServisa(rentacar.getProsecnaOcenaServisa());
		rentACarRepository.save(r);
		
		return r;
	}

	@Override
	public HashSet<Filijala> getSpisakFilijala(Long rentacarId) {
		RentACar rentacar = findById(rentacarId);
		
		return filijalaRepository.findByRentACar(rentacar);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Filijala addFilijala(FilijalaDTO filijala, Long rentacarId) {
		Filijala filijalaNew = new Filijala();
		filijalaNew.setGrad(filijala.getGrad());
		filijalaNew.setDrzava(filijala.getDrzava());
	
		RentACar rentacar = findById(rentacarId);
				
		filijalaNew.setRentACar(rentacar);
		
		filijalaRepository.save(filijalaNew);
      
        return filijalaNew;
	}

	@Override
	public Filijala getFilijala(Long id) {
		return filijalaRepository.findOneById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Filijala updateFilijala(FilijalaDTO filijala) {
		Filijala filijalaToUpdate = new Filijala();
		filijalaToUpdate.setId(filijala.getId());
		filijalaToUpdate.setGrad(filijala.getGrad());
		filijalaToUpdate.setDrzava(filijala.getDrzava());
		filijalaToUpdate.setVersion(filijala.getVersion());
	
		RentACar rentacar = getFilijala(filijala.getId()).getRentACar();
		
		filijalaToUpdate.setRentACar(new RentACar(rentacar.getId(),rentacar.getNazivServisa(),rentacar.getAdresaServisa(),rentacar.getOpisServisa(),new HashSet<Filijala>(),new HashSet<Vozilo>(),rentacar.getProsecnaOcenaServisa()));

		filijalaRepository.save(filijalaToUpdate);
      
        return filijalaToUpdate;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public HashSet<Filijala> deleteFilijala(Long id, Long rentacarId) {
		filijalaRepository.delete(getFilijala(id));
		
		return getSpisakFilijala(rentacarId);
	}

	@Override
	public HashSet<Vozilo> getNerezervisanaVozila(Long rentacarId) {
		RentACar rentacar = findById(rentacarId);
		
		HashSet<Vozilo> vozila = voziloRepository.findByRentACar(rentacar);
		
		for (Vozilo vozilo : voziloRepository.findRezVozila(rentacarId, LocalDate.now())) {
			vozila.remove(vozilo);
		}
		
		return vozila;
	}

	@Override
	public List<Vozilo> getRezervisanaVozila(Long rentacarId) {
		LocalDate today = LocalDate.now();
		return voziloRepository.findRezVozila(rentacarId, today);
	}

	@Override
	public Vozilo getVozilo(Long id) {
		return voziloRepository.findOneById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Vozilo updateVozilo(VoziloDTO vozilo) {
		Vozilo voziloToUpdate = new Vozilo();
		voziloToUpdate.setId(vozilo.getId());
		voziloToUpdate.setRegistracijaVozila(vozilo.getRegistracijaVozila());
		voziloToUpdate.setMarkaVozila(vozilo.getMarkaVozila());
		voziloToUpdate.setModelVozila(vozilo.getModelVozila());
		voziloToUpdate.setGodinaProizvodnje(vozilo.getGodinaProizvodnje());
		voziloToUpdate.setBrojSedista(vozilo.getBrojSedista());
		voziloToUpdate.setVersion(vozilo.getVersion());
		
		RentACar rentacar = getVozilo(vozilo.getId()).getRentACar();
		
		voziloToUpdate.setRentACar(new RentACar(rentacar.getId(),rentacar.getNazivServisa(),rentacar.getAdresaServisa(),rentacar.getOpisServisa(),new HashSet<Filijala>(),new HashSet<Vozilo>(),rentacar.getProsecnaOcenaServisa()));

		voziloRepository.save(voziloToUpdate);
      
        return voziloToUpdate;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Vozilo addVozilo(VoziloDTO vozilo, Long rentacarId) {
		Vozilo voziloToUpdate = new Vozilo();

		voziloToUpdate.setRegistracijaVozila(vozilo.getRegistracijaVozila());
		voziloToUpdate.setMarkaVozila(vozilo.getMarkaVozila());
		voziloToUpdate.setModelVozila(vozilo.getModelVozila());
		voziloToUpdate.setGodinaProizvodnje(vozilo.getGodinaProizvodnje());
		voziloToUpdate.setBrojSedista(vozilo.getBrojSedista());
		
		RentACar rentacar = findById(rentacarId);
				
		voziloToUpdate.setRentACar(rentacar);
		
		voziloRepository.save(voziloToUpdate);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse("2019-01-01", formatter);
        
        for(int i = 0; i < 365; i++) {
        	StatusVozila sv = new StatusVozila();
        	sv.setVozilo(voziloToUpdate);
        	sv.setDatum(datum);
        	sv.setVoziloJeIznajmljeno(false);
        	sv.setCena(2500);
        	sv.setPopust((short)0);
        	statusVozilaRepository.save(sv);
        	
        	datum = datum.plusDays(1);
        }
      
        return voziloToUpdate;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public HashSet<Vozilo> deleteVozilo(Long id, Long rentacarId) {
		voziloRepository.delete(getVozilo(id));
		
		return getNerezervisanaVozila(rentacarId);
	}

	@Override
	public List<Ocena> getOceneRentacar(RentACar rentacar) {
		return ocenaRepository.findByRentACar(rentacar);
	}

	@Override
	public List<Ocena> getOceneVozila(Vozilo vozilo) {
		return ocenaRepository.findByVozilo(vozilo);
	}

	@Override
	public Double getPrihode(Long rentacarId, LocalDate from, LocalDate to) {
		return voziloRepository.findPrihodiRentacar(rentacarId, from, to);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<StatusVozila> setStatuse(Long voziloId, Double cena, Short popust, LocalDate from, LocalDate to) {
		List<StatusVozila> statusiVozila = statusVozilaRepository.findInDateByVozilo(voziloId,from,to);
		
		for (StatusVozila sv : statusiVozila) {
			sv.setCena(cena);
			sv.setPopust(popust);
			
			statusVozilaRepository.save(sv);
		}
		
		return statusiVozila;
	}

	@Override
	public List<Vozilo> getVoziloZaRez(Double cenaFrom, Double cenaTo, LocalDate datumFrom, LocalDate datumTo, int brojSedista) {
		Long days = ChronoUnit.DAYS.between(datumFrom, datumTo) + 1;
		
		List<Vozilo> vozila = voziloRepository.findVozilaZaRez(cenaFrom, cenaTo, datumFrom, datumTo, brojSedista, days);
		
		return vozila;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public RentACar addRent(RentACarDTO rent) {
		RentACar rentNew = new RentACar();

		rentNew.setNazivServisa(rent.getNazivServisa());
		rentNew.setAdresaServisa(rent.getAdresaServisa());
		rentNew.setOpisServisa(rent.getOpisServisa());
		rentNew.setProsecnaOcenaServisa(0.0);
		
        rentACarRepository.save(rentNew);
        
        return rentNew;
	}
	
	@Override
	public List<RentACar> getAllNull() {
		
		List<RentACar> rent = rentACarRepository.findAll();
		
		List<RentACar> rentNull = new ArrayList<>();
		
		for (RentACar r : rent) {
			if(r.getAdmin()==null) {
				rentNull.add(r);
			}
		}
		
		return rentNull;
	}

	@Override
	public Ocena addOcenaRentacar(Long korisnikId, RentACarDTO rentacar, int ocena) {
		// TODO Auto-generated method stub
		Ocena ocenaNew = new Ocena();
		ocenaNew.setVrednost((byte)ocena);
	
		RentACar rent = findById(rentacar.getId());
		Korisnik kor = korisnikRepository.findById(korisnikId);
		
		ocenaNew.setRentACar(rent);
		ocenaNew.setKorisnik(kor);
		
		ocenaRepository.save(ocenaNew);
      
        return ocenaNew;
		
	}

	@Override
	public double getUkupnaCena(Long voziloId, LocalDate from, LocalDate to) {
		return statusVozilaRepository.findUkupnaCena(voziloId, from, to);
	}

	@Override
	public List<VozilaBrzaDTO> getVozilaBrza(LocalDate from, LocalDate to) {
		Long days = ChronoUnit.DAYS.between(from, to) + 1;

		List<Vozilo> vozila = voziloRepository.findVozilaBrza(from,to,days);

		List<VozilaBrzaDTO> vozilaDTO = new ArrayList<>();

		for (Vozilo v : vozila) {
			VozilaBrzaDTO vDTO = new VozilaBrzaDTO();
			vDTO.setRegistracijaVozila(v.getRegistracijaVozila());
			vDTO.setBrojSedista(v.getBrojSedista());
			vDTO.setMarkaVozila(v.getMarkaVozila());
			vDTO.setModelVozila(v.getModelVozila());
			vDTO.setId(v.getId());
			vDTO.setPopust(statusVozilaRepository.findPopust(v.getId(), from));
			vDTO.setCena(statusVozilaRepository.findUkupnaCena(v.getId(), from, to));

			vozilaDTO.add(vDTO);
		}


		return vozilaDTO;
	}

	@Override
	public List<RezervacijaDTO> getRezervacijeKorisnika(Long korisnikId) {
		// TODO Auto-generated method stub
		
		List<RezervacijaDTO> rDTO = new ArrayList<>();
		List<Rezervacija> rezervacije = rezervacijaRepository.findRezervacijeKorisnika(korisnikId);
		
		for(Rezervacija r : rezervacije) {
			RezervacijaDTO rd = new RezervacijaDTO();

			
		}
		
		return null;
	}
}

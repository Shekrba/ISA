package isa.putujIgumane.service.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.korisnik.RezervacijaDTO;
import isa.putujIgumane.dto.rentacar.FilijalaDTO;
import isa.putujIgumane.dto.rentacar.RentACarDTO;
import isa.putujIgumane.dto.rentacar.VozilaBrzaDTO;
import isa.putujIgumane.dto.rentacar.VoziloDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.model.rentACar.Filijala;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.StatusVozila;
import isa.putujIgumane.model.rentACar.Vozilo;


public interface RentACarService {

	public List<RentACar> getAll();
	public RentACar findById(Long id);
	public HashSet<Vozilo> findVoziloByRentACar(RentACar rentacar);
	public HashSet<StatusVozila> findStatusByVozilo(Vozilo vozilo);
	public List<Vozilo> getFreeVozilo(Long rentacarId, LocalDate from, LocalDate to);
	public RentACar update(RentACarDTO rentacar) throws Exception;
	public HashSet<Filijala> getSpisakFilijala(Long rentacarId);
	public Filijala addFilijala(FilijalaDTO filijala,Long rentacarId);
	public Filijala getFilijala(Long id);
	public Filijala updateFilijala(FilijalaDTO filijala);
	public HashSet<Filijala> deleteFilijala(Long id,Long rentacarId);
	public HashSet<Vozilo> getNerezervisanaVozila(Long rentacarId);
	public List<Vozilo> getRezervisanaVozila(Long rentacarId);
	public Vozilo getVozilo(Long id);
	public Vozilo updateVozilo(VoziloDTO vozilo);
	public Vozilo addVozilo(VoziloDTO vozilo,Long rentacarId);
	public HashSet<Vozilo> deleteVozilo(Long id,Long rentacarId);
	public List<Ocena> getOceneRentacar(RentACar rentacar);
	public List<Ocena> getOceneVozila(Vozilo vozilo);
	public Double getPrihode(Long rentacarId, LocalDate from, LocalDate to);
	public List<StatusVozila> setStatuse(Long voziloId,Double cena, Short popust, LocalDate from, LocalDate to);
	public List<Vozilo> getVoziloZaRez(Double cenaFrom,Double cenaTo,LocalDate datumFrom, LocalDate datumTo, int brojSedista);
	public RentACar addRent(RentACarDTO rent);
	public List<RentACar> getAllNull();
	public Ocena addOcenaRentacar(Long korisnikId, RentACarDTO rentacar, int ocena);
	public double getUkupnaCena(Long voziloId, LocalDate from, LocalDate to);
	public List<VozilaBrzaDTO> getVozilaBrza(LocalDate from, LocalDate to);
	public List<RezervacijaDTO> getRezervacijeKorisnika(Long korisnikId);

}
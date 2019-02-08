package isa.putujIgumane.service.hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.hotel.SobeBrzaDTO;
import isa.putujIgumane.model.hotel.CenovnikUslugaHotela;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.hotel.StatusSobe;
import isa.putujIgumane.model.korisnik.Ocena;


@Service
public interface HotelService {
	
	public abstract List<Hotel> getAll();
	public abstract List<Hotel> getAllNull();
	public abstract Hotel findById(Long id);
	public abstract HashSet<Soba> getSveSobe(Hotel hotel);
	public abstract HashSet<StatusSobe> findStatusBySoba(Soba soba);
	public abstract List<Soba> getFreeSoba(Long hotelId, LocalDate from, LocalDate to);
	public abstract Hotel update(HotelDTO hotel) throws Exception;
	public abstract HashSet<CenovnikUslugaHotela> getCenovnik(Long hotelId);
	public abstract CenovnikUslugaHotela getUsluga(Long id);
	public abstract CenovnikUslugaHotela updateCenovnik(CenovnikUslugaHotelaDTO cenovnik);
	public abstract CenovnikUslugaHotela addCenovnik(CenovnikUslugaHotelaDTO cenovnik,Long hotelId);
	public abstract HashSet<CenovnikUslugaHotela> deleteCenovnik(Long id,Long hotelId);
	public abstract HashSet<Soba> getNerezervisaneSobe(Long hotelId);
	public abstract List<Soba> getRezervisaneSobe(Long hotelId);
	public abstract Soba getSoba(Long id);
	public abstract Soba updateSoba(SobaDTO soba);
	public abstract Soba addSoba(SobaDTO soba,Long hotelId);
	public abstract HashSet<Soba> deleteSoba(Long id,Long hotelId);
	public abstract List<Ocena> getOceneHotela(Hotel hotel);
	public abstract List<Ocena> getOceneSobe(Soba soba);
	public abstract Double getPrihode(Long hotelId, LocalDate from, LocalDate to);
	public abstract List<StatusSobe> setStatuse(Long sobaId,Double cena, Short popust, LocalDate from, LocalDate to);
	public abstract List<Soba> getSobeZaRez(Long hotelId, Double cenaFrom,Double cenaTo,LocalDate datumFrom, LocalDate datumTo,boolean jen,boolean dvo,boolean tro,boolean cet);
	public abstract Hotel addHotel(HotelDTO hotel);
	public abstract List<SobeBrzaDTO> getSobeBrza(Long hotelId,LocalDate from, LocalDate to);
	public abstract double getUkupnaCena(Long sobaId, LocalDate from, LocalDate to);
}

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


public interface HotelService {
	
	public List<Hotel> getAll();
	public List<Hotel> getAllNull();
	public Hotel findById(Long id);
	public HashSet<Soba> getSveSobe(Hotel hotel);
	public HashSet<StatusSobe> findStatusBySoba(Soba soba);
	public List<Soba> getFreeSoba(Long hotelId, LocalDate from, LocalDate to);
	public Hotel update(HotelDTO hotel) throws Exception;
	public HashSet<CenovnikUslugaHotela> getCenovnik(Long hotelId);
	public CenovnikUslugaHotela getUsluga(Long id);
	public CenovnikUslugaHotela updateCenovnik(CenovnikUslugaHotelaDTO cenovnik);
	public CenovnikUslugaHotela addCenovnik(CenovnikUslugaHotelaDTO cenovnik,Long hotelId);
	public HashSet<CenovnikUslugaHotela> deleteCenovnik(Long id,Long hotelId);
	public HashSet<Soba> getNerezervisaneSobe(Long hotelId);
	public List<Soba> getRezervisaneSobe(Long hotelId);
	public Soba getSoba(Long id);
	public Soba updateSoba(SobaDTO soba);
	public Soba addSoba(SobaDTO soba,Long hotelId);
	public HashSet<Soba> deleteSoba(Long id,Long hotelId);
	public List<Ocena> getOceneHotela(Hotel hotel);
	public List<Ocena> getOceneSobe(Soba soba);
	public Double getPrihode(Long hotelId, LocalDate from, LocalDate to);
	public List<StatusSobe> setStatuse(Long sobaId,Double cena, Short popust, LocalDate from, LocalDate to);
	public List<Soba> getSobeZaRez(Long hotelId, Double cenaFrom,Double cenaTo,LocalDate datumFrom, LocalDate datumTo,boolean jen,boolean dvo,boolean tro,boolean cet);
	public Hotel addHotel(HotelDTO hotel);
	public List<SobeBrzaDTO> getSobeBrza(Long hotelId,LocalDate from, LocalDate to);
	public double getUkupnaCena(Long sobaId, LocalDate from, LocalDate to);
}

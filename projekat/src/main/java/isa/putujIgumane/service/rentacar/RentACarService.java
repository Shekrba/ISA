package isa.putujIgumane.service.rentacar;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import isa.putujIgumane.dto.hotel.CenovnikUslugaHotelaDTO;
import isa.putujIgumane.dto.hotel.HotelDTO;
import isa.putujIgumane.dto.hotel.SobaDTO;
import isa.putujIgumane.dto.rentacar.FilijalaDTO;
import isa.putujIgumane.dto.rentacar.RentACarDTO;
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

@Service
public interface RentACarService {

	public abstract List<RentACar> getAll();
	public abstract RentACar findById(Long id);
	public abstract HashSet<Vozilo> findVoziloByRentACar(RentACar rentacar);
	public abstract HashSet<StatusVozila> findStatusByVozilo(Vozilo vozilo);
	public abstract List<Vozilo> getFreeVozilo(Long rentacarId, LocalDate from, LocalDate to);
	public abstract RentACar update(RentACarDTO rentacar) throws Exception;
	public abstract HashSet<Filijala> getSpisakFilijala(Long rentacarId);
	public abstract Filijala addFilijala(FilijalaDTO filijala,Long rentacarId);
	public abstract Filijala getFilijala(Long id);
	public abstract Filijala updateFilijala(FilijalaDTO filijala);
	public abstract HashSet<Filijala> deleteFilijala(Long id,Long rentacarId);
	public abstract HashSet<Vozilo> getNerezervisanaVozila(Long rentacarId);
	public abstract List<Vozilo> getRezervisanaVozila(Long rentacarId);
	public abstract Vozilo getVozilo(Long id);
	public abstract Vozilo updateVozilo(VoziloDTO vozilo);
	public abstract Vozilo addVozilo(VoziloDTO vozilo,Long rentacarId);
	public abstract HashSet<Vozilo> deleteVozilo(Long id,Long rentacarId);
	public abstract List<Ocena> getOceneRentacar(RentACar rentacar);
	public abstract List<Ocena> getOceneVozila(Vozilo vozilo);
	public abstract Double getPrihode(Long rentacarId, LocalDate from, LocalDate to);
	public abstract List<StatusVozila> setStatuse(Long voziloId,Double cena, Short popust, LocalDate from, LocalDate to);
	public abstract List<Vozilo> getVoziloZaRez(Double cenaFrom,Double cenaTo,LocalDate datumFrom, LocalDate datumTo, int brojSedista);

}

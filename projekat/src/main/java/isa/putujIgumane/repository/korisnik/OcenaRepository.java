package isa.putujIgumane.repository.korisnik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.putujIgumane.model.avioKompanija.AvioKompanija;
import isa.putujIgumane.model.avioKompanija.Let;
import isa.putujIgumane.model.hotel.Hotel;
import isa.putujIgumane.model.hotel.Soba;
import isa.putujIgumane.model.korisnik.Ocena;
import isa.putujIgumane.model.rentACar.RentACar;
import isa.putujIgumane.model.rentACar.Vozilo;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {
	
	List<Ocena> findByHotel(Hotel hotel);
	List<Ocena> findBySoba(Soba soba);
	
	List<Ocena> findByRentACar(RentACar rentacar);
	List<Ocena> findByVozilo(Vozilo vozilo);
	
	List<Ocena> findByAvioKompanija(AvioKompanija ak);
	List<Ocena> findByLet(Let let);
}

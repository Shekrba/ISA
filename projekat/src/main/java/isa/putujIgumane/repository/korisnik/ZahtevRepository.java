package isa.putujIgumane.repository.korisnik;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isa.putujIgumane.model.korisnik.Korisnik;
import isa.putujIgumane.model.korisnik.Zahtev;

public interface ZahtevRepository extends JpaRepository<Zahtev,Long> {
	
	@Query("SELECT z.prima.id FROM Zahtev z  WHERE z.salje.username=?1 AND (z.status=1 OR z.status=2)")		
	List<Long> findFriendsAndSentRequests(String username);
	
	@Query("SELECT z.salje.id FROM Zahtev z WHERE z.prima.username=?1 AND (z.status=1 OR z.status=2)")
	List<Long> findFriendsAndRecievedRequests(String username);
	
	@Query("SELECT z FROM Korisnik k JOIN  k.primljeniZahtevi z JOIN z.salje s WHERE k.username=?1 AND z.status=2")
	List<Zahtev> findRequestsOfUser(String username);
}

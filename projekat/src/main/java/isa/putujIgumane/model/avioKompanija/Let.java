package isa.putujIgumane.model.avioKompanija;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

public class Let {

	private Set<Segment> segmenti=new HashSet<Segment>();
	
	private Date vremePoletanja;
	
	private Date vremeSletanja;
	
	private Time vremePutovanja;
	
	private int duzinaPutovanja;
	
	private Set<Destinacija> destinacije=new HashSet<Destinacija>();

	private double cena;
}

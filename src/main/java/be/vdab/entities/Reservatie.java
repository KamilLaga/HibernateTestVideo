package be.vdab.entities;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.*;

import be.vdab.keys.ReservatieKey;

@Entity
@IdClass(ReservatieKey.class)
@Table(name="reservaties")
public class Reservatie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private int klantNr;
	@Id
	private int filmNr;
	@Id
	private String reservatieDatum;
	
	protected Reservatie() {}
	
	public Reservatie(int klantNr, int filmNr) {
		this.klantNr = klantNr;
		this.filmNr = filmNr;
		
		Date huidigeDatum = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.reservatieDatum = df.format(huidigeDatum);
		
	}
	
	
	public int getKlantNr() {
		return klantNr;
	}
	
	public int getFilmNr() {
		return filmNr;
	}
	
	public String getReservatieDatum() {
		return reservatieDatum;
	}
	
}

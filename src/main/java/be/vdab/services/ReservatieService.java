package be.vdab.services;

import be.vdab.DAO.FilmDAO;
import be.vdab.DAO.ReservatieDAO;
import be.vdab.entities.Film;
import be.vdab.entities.Reservatie;

public class ReservatieService {
	
	private final FilmDAO filmDAO = new FilmDAO();
	private final ReservatieDAO reservatieDAO = new ReservatieDAO();
	
	public void maakReservatie(int filmNr, int klantNr) {
		reservatieDAO.beginTransaction();
		Film film = filmDAO.read(filmNr);
		film.isGereserveerd();
		Reservatie reservatie = new Reservatie(filmNr, klantNr);
		reservatieDAO.create(reservatie);
		reservatieDAO.commit();
	}

}

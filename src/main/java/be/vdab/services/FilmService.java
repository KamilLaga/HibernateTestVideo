package be.vdab.services;

import java.util.List;

import be.vdab.DAO.FilmDAO;
import be.vdab.entities.Film;

public class FilmService {
	private final FilmDAO filmDAO = new FilmDAO();
	
	public List<Film> findFilmsByGenre(int genreNr) {
		return filmDAO.findByGenre(genreNr);
	}
	
	public Film read(int FilmNr) {
		return filmDAO.read(FilmNr);
	}
	
}

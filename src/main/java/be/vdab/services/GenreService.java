package be.vdab.services;

import java.util.List;


import be.vdab.DAO.GenreDAO;
import be.vdab.entities.Genre;

public class GenreService {
	private final GenreDAO genreDAO = new GenreDAO();
	
	public List<Genre> findAll() {
		return genreDAO.findAll();
	}

}

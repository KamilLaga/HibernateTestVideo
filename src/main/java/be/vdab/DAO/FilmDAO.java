package be.vdab.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import be.vdab.entities.Film;


public class FilmDAO extends AbstractDAO {
	
	public List<Film> findByGenre(int genreNr) {
		
		TypedQuery<Film> query = getEntityManager().createNamedQuery("findFilmsByGenre", Film.class);
		query.setParameter("genreNr", genreNr);
		return query.getResultList();
	}

	public Film read(int filmNr) {
	
		return getEntityManager().find(Film.class, filmNr);
	
	}
}
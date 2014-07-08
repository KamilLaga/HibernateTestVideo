

package be.vdab.DAO;


import java.util.List;

import be.vdab.entities.Genre;


import javax.persistence.TypedQuery;


public class GenreDAO extends AbstractDAO {
    
	
	public List<Genre> findAll() {
		
		TypedQuery<Genre> query = getEntityManager().createNamedQuery("findAllGenres", Genre.class);
		return query.getResultList();
	}
    
    
    
    
}

package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kamil.laga
 */
@Entity
@Table(name = "genres")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    private long genreNr;
    private String naam;
    
    public Genre(long genreNr, String naam) {
        this.genreNr =genreNr;
        setNaam(naam);
    }
    protected Genre() {}
    
    
    public long getGenreNr() {
        return genreNr;
    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getNaam() {
        return naam;
    }
}

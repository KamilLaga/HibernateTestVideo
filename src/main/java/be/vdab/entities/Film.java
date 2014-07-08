package be.vdab.entities;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="films")
public class Film {
	@Id
	private int filmNr;
    private int genreNr;
    private String titel;
    private long voorraad;
    private long gereserveerd;
    private BigDecimal prijs;
    @Transient
    private long beschikbaar;
    
    protected Film() {}
    public Film(int filmNr, int genreNr, String titel, long voorraad, long gereserveerd, BigDecimal prijs) {
        this.filmNr =filmNr;
        this.genreNr =genreNr;
        setTitel(titel);
        setVoorraad(voorraad);
        setGereserveerd(gereserveerd);
        setPrijs(prijs);
    }
    

    public int getFilmNr() {
        return filmNr;
    }
    

    public int getGenreNr() {
        return genreNr;
    }
   

    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public long getVoorraad() {
        return voorraad;
    }
    public void setVoorraad(long voorraad) {
        this.voorraad = voorraad;
    }

    public long getGereserveerd() {
        return gereserveerd;
    }
    public void setGereserveerd(long gereserveerd) {
        this.gereserveerd = gereserveerd;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    
    public long getBeschikbaar() {
        return voorraad - gereserveerd;
    }
    
    public boolean isBeschikbaar() {
    	if (gereserveerd < voorraad) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void isGereserveerd() {
    	this.gereserveerd++;
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

import javax.persistence.*;

/**
 *
 * @author kamil.laga
 */
@Entity
@Table(name="klanten")
public class Klant {
	@Id
    private long KlantNr;
    private String familienaam;
    private String voornaam;
    private String StraatNummer;
    private String Postcode;
    private String Gemeente;
    
    
    protected Klant() {}
    public Klant(long KlantNr, String familienaam, String Voornaam, String StraatNummer, String Postcode, String Gemeente) {
        setKlantNr(KlantNr);
        setFamilienaam(familienaam);
        setVoornaam(voornaam);
        setStraatNummer(StraatNummer);
        setPostcode(Postcode);
        setGemeente(Gemeente);
    }


    public long getKlantNr() {
        return KlantNr;
    }
    public void setKlantNr(long KlantNr) {
        this.KlantNr = KlantNr;
    }

    public String getFamilienaam() {
        return familienaam;
    }
    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraatNummer() {
        return StraatNummer;
    }
    public void setStraatNummer(String StraatNummer) {
        this.StraatNummer = StraatNummer;
    }

    public String getPostcode() {
        return Postcode;
    }
    public void setPostcode(String Postcode) {
        this.Postcode = Postcode;
    }

    public String getGemeente() {
        return Gemeente;
    }
    public void setGemeente(String Gemeente) {
        this.Gemeente = Gemeente;
    }
    

}

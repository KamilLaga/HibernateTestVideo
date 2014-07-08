package be.vdab.services;

import java.util.List;

import be.vdab.DAO.KlantDAO;
import be.vdab.entities.Klant;

public class KlantService {
	private final KlantDAO klantDAO = new KlantDAO();
	
	public List<Klant> findByFamilienaam(String familienaam) {
		return klantDAO.findByFamilienaam(familienaam);
	}
	
	public Klant read(int klantNr) {
		return klantDAO.read(klantNr);
	}
}

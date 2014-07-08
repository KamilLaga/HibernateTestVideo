package be.vdab.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import be.vdab.entities.Klant;

public class KlantDAO extends AbstractDAO {
	
	public List<Klant> findByFamilienaam(String familienaam) {
		
		TypedQuery<Klant> query = getEntityManager().createNamedQuery("findKlantenByFamilienaam", Klant.class);
		query.setParameter("familienaam", "%" +familienaam+"%");
		return query.getResultList();
	}
	
	public Klant read(int klantNr) {
		
		return getEntityManager().find(Klant.class, klantNr);
	}

}
